package com.greengames.mathgames.primefactorization.ui;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.GridView;

import java.util.List;

/**
 * Adapter for available primes number for factorization.
 */
public class AvailableNumbersAdapter extends BaseAdapter {

    private final int max;
    private final List<Integer> primes;
    private Context context;

    public AvailableNumbersAdapter(Context context, int max) {
        this.context = context;
        this.max = max;
        primes = com.greengames.mathgames.primefactorization.model.Number.primesUnder(max);
    }

    @Override
    public int getCount() {
        return primes.size();
    }

    @Override
    public Object getItem(int i) {
        return primes.get(i);
    }

    @Override
    public long getItemId(int i) {
        return i;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        Button button;
        if (view == null) {
            button = new Button(context);
            button.setLayoutParams(new GridView.LayoutParams(GridView.LayoutParams.MATCH_PARENT, GridView.LayoutParams.WRAP_CONTENT));
        } else {
            button = (Button) view;
        }
        button.setText(String.valueOf(getItem(i)));
        return button;
    }
}
