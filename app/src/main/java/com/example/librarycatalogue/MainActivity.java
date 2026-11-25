package com.example.librarycatalogue;

import android.os.Bundle;
import android.view.View;
import android.view.LayoutInflater;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.google.android.material.chip.Chip;

public class MainActivity extends AppCompatActivity {
    private static final int[] CATEGORY_LABELS = {
            R.string.category_computer_science,
            R.string.category_mathematics,
            R.string.category_programming,
            R.string.category_networking,
            R.string.category_database
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        bindCategories();
        bindBookCard(R.id.book_clean_code, R.string.book_clean_code, R.string.author_robert_martin,
                R.color.cover_blue);
        bindBookCard(R.id.book_design_patterns, R.string.book_design_patterns,
                R.string.author_erich_gamma, R.color.cover_teal);
        bindBookCard(R.id.book_computer_networks, R.string.book_computer_networks,
                R.string.author_andrew_tanenbaum, R.color.cover_coral);
    }

    private void bindCategories() {
        LinearLayout categoryContainer = findViewById(R.id.category_container);
        LayoutInflater inflater = LayoutInflater.from(this);

        for (int labelId : CATEGORY_LABELS) {
            Chip category = (Chip) inflater.inflate(R.layout.item_category, categoryContainer, false);
            category.setText(labelId);

            LinearLayout.LayoutParams params = new LinearLayout.LayoutParams(
                    LinearLayout.LayoutParams.WRAP_CONTENT,
                    LinearLayout.LayoutParams.WRAP_CONTENT);
            params.setMarginEnd(getResources().getDimensionPixelSize(R.dimen.category_spacing));
            categoryContainer.addView(category, params);
        }
    }

    private void bindBookCard(int cardId, int titleId, int authorId, int coverColorId) {
        View card = findViewById(cardId);
        ((TextView) card.findViewById(R.id.book_title)).setText(titleId);
        ((TextView) card.findViewById(R.id.book_author)).setText(authorId);
        card.findViewById(R.id.book_cover).setBackgroundTintList(
                android.content.res.ColorStateList.valueOf(getColor(coverColorId)));
    }
}
