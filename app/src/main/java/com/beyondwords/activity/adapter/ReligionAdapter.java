package com.beyondwords.activity.adapter;

import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.inputmethod.InputMethodManager;
import android.widget.CheckBox;
import android.widget.Filterable;
import android.widget.ImageView;
import android.widget.TextView;

import android.widget.Filter;
import android.widget.Filterable;


import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewpager.widget.ViewPager;

import com.beyondwords.R;
import com.beyondwords.model.PersonInfo;

import java.util.ArrayList;
import java.util.List;

public class ReligionAdapter extends RecyclerView.Adapter<ReligionAdapter.SingleViewHolder> implements Filterable {

    private Context context;
    private ArrayList<String> options;
    ViewPager viewPager;

    private List<String> itemListFiltered=new ArrayList<>();
    // if checkedPosition = -1, there is no default selection
    // if checkedPosition = 0, 1st item is selected by default
    private int checkedPosition = -1;

    public ReligionAdapter(Context context, ArrayList<String> options, ViewPager viewPager) {
        this.context = context;
        this.options = options;
        this.viewPager=viewPager;
    }

    public ReligionAdapter(Context context, ArrayList<String> options) {
        this.context = context;
        this.options = options;
        this.itemListFiltered=options;
    }

    public void setEmployees(ArrayList<String> employees) {
        this.options = new ArrayList<>();
        this.options = employees;
        notifyDataSetChanged();
    }

    @NonNull
    @Override
    public SingleViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view = LayoutInflater.from(context).inflate(R.layout.survey_item_layout, viewGroup, false);
        return new SingleViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull SingleViewHolder singleViewHolder, int position) {
        singleViewHolder.bind(itemListFiltered.get(position));
    }

    @Override
    public int getItemCount() {
        return itemListFiltered.size();
    }

    class SingleViewHolder extends RecyclerView.ViewHolder {

        private TextView textView;
        private CheckBox checkBox;

        SingleViewHolder(@NonNull View itemView) {
            super(itemView);
            textView = itemView.findViewById(R.id.textView);
            checkBox = itemView.findViewById(R.id.checkb);
        }

        void bind(final String option) {
            if (checkedPosition == -1) {
                checkBox.setChecked(false);
            } else {
                if (checkedPosition == getAdapterPosition()) {
                    checkBox.setChecked(true);
                } else {
                    checkBox.setChecked(false);
                }
            }
            textView.setText(option);

            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {


                    closeKeyboard();
                    checkBox.setChecked(true);
                    if (checkedPosition != getAdapterPosition()) {
                        notifyItemChanged(checkedPosition);
                        checkedPosition = getAdapterPosition();
                    }
                    PersonInfo.getInstance().setmReligion(textView.getText().toString());
                    //System.out.println(textView.getText().toString());
                }
            });
        }
    }

    public String getSelected() {
        if (checkedPosition != -1) {
            return options.get(checkedPosition);
        }
        return null;
    }

    @Override
    public Filter getFilter() {
        return new Filter() {
            @Override
            protected FilterResults performFiltering(CharSequence constraint) {

                String charString = constraint.toString();

                System.out.println(charString);

                if (charString.isEmpty()){
                    itemListFiltered = options;
                }else{

                    ArrayList<String> filterList = new ArrayList<>();

                    for (String data : options){

                        if (data.toLowerCase().contains(charString)){
                            filterList.add(data);
                            System.out.println(data);
                        }
                    }


                    itemListFiltered = filterList;

                }

                FilterResults filterResults = new FilterResults();
                filterResults.values = itemListFiltered;

                return filterResults;
            }

            @Override
            protected void publishResults(CharSequence constraint, FilterResults results) {

                itemListFiltered = (ArrayList<String>) results.values;
                System.out.println("published");
                notifyDataSetChanged();
            }
        };

    }

    private void closeKeyboard() {

        Activity activity = (Activity) context;

        View view = activity.getCurrentFocus();


        if (view != null) {
            InputMethodManager imm = (InputMethodManager)activity.getSystemService(Context.INPUT_METHOD_SERVICE);
            imm.hideSoftInputFromWindow(view.getWindowToken(), 0);
        }

    }



}