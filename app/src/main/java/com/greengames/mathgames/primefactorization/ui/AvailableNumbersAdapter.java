package com.greengames.mathgames.primefactorization.ui;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Button;

import com.greengames.mathgames.R;

import java.util.List;

/**
 * Adapter for available primes number for factorization.
 */
public class AvailableNumbersAdapter extends BaseAdapter {

    private final int max;
    private final List<Integer> primes;
    private Context context;
    private LayoutInflater layoutInflater;

    public AvailableNumbersAdapter(Context context, int max) {
        this.context = context;
        this.max = max;
        primes = com.greengames.mathgames.primefactorization.model.Number.primesUnder(max);
        layoutInflater = ((LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE));
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
            button = (Button) layoutInflater.inflate(R.layout.available_prime_item, null);
        } else {
            button = (Button) view;
        }
        button.setText(String.valueOf(getItem(i)));
        return button;
    }
}
