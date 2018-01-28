package name.juhasz.judit.udacity.joketeller;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class JokeDisplayActivity extends AppCompatActivity {

    public static final String EXTRA_DATA = "EXTRA_DATA";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_joke_display);

        TextView jokeDisplayTextView = (TextView) findViewById(R.id.tv_joke_text);

        String jokeResult = null;
        Intent intent = getIntent();

        if (null != intent && intent.hasExtra(EXTRA_DATA)) {
            jokeResult = intent.getStringExtra(EXTRA_DATA);
            jokeDisplayTextView.setText(jokeResult);
        } else {
            jokeDisplayTextView.setText(getString(R.string.error_no_joke_available));
        }

    }
}
