package com.beyondwords.activity.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewpager.widget.ViewPager;

import com.beyondwords.R;

import java.util.ArrayList;

public class SingleAdapter2 extends RecyclerView.Adapter<SingleAdapter2.SingleViewHolder> {

    private Context context;
    private ArrayList<String> options;
    ViewPager viewPager;
    // if checkedPosition = -1, there is no default selection
    // if checkedPosition = 0, 1st item is selected by default
    private int checkedPosition = -1;

    public SingleAdapter2(Context context, ArrayList<String> options, ViewPager viewPager) {
        this.context = context;
        this.options = options;
        this.viewPager=viewPager;
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
        singleViewHolder.bind(options.get(position));
    }

    @Override
    public int getItemCount() {
        return options.size();
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

                    checkBox.setChecked(true);
                    if (checkedPosition != getAdapterPosition()) {
                        notifyItemChanged(checkedPosition);
                        checkedPosition = getAdapterPosition();
                    }
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
}