package com.greengames.mathgames.primefactorization.ui;

import android.widget.GridView;
import android.widget.TextView;

import com.greengames.mathgames.R;
import com.greengames.mathgames.commons.ui.BaseActivity;
import com.greengames.mathgames.primefactorization.model.Number;

import org.androidannotations.annotations.AfterViews;
import org.androidannotations.annotations.EActivity;
import org.androidannotations.annotations.ViewById;


/**
 * Prime numbers decomposition game
 */
@EActivity(R.layout.activity_prime_factorization)
public class PrimeFactorizationActivity extends BaseActivity {

    @ViewById(R.id.number)
    TextView numberLabel;

    @ViewById(R.id.available_numbers)
    GridView availableNumbers;

    private Number number = new Number(1000);

    @AfterViews
    void setUpAvailableNumbers() {
        AvailableNumbersAdapter adapater = new AvailableNumbersAdapter(this, 1000);
        availableNumbers.setAdapter(adapater);
    }

    @AfterViews
    void setUpNumber() {
        numberLabel.setText(String.valueOf(number.getNumber()));
    }
}
