package ui.quiz.tulaa.io.quizapp;

import android.app.ProgressDialog;
import android.content.Context;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.util.Log;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.support.v7.widget.Toolbar;
import android.widget.Toast;

import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import ui.quiz.tulaa.io.quizapp.io.ApiEndpointInterface;
import ui.quiz.tulaa.io.quizapp.util.Config;
import ui.quiz.tulaa.io.quizapp.util.NetworkConnectionStatus;

public class MainActivity extends AppCompatActivity {
    private String TAG = "MainActivity";
    @BindView(R.id.textInputEditText)
    EditText textInputEditText;

    @BindView(R.id.textOutputTextView)
    TextView textOutputTextView;

    @BindView(R.id.reverseTextButton)
    Button reverseTextButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);


        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        setTitle("");


        TextView mTitleTextView = toolbar.findViewById(R.id.toolbar_title);
        mTitleTextView.setText(R.string.app_name);



    }



    /**
     * Call a web service endpoint to reverse text.
     */
    @OnClick(R.id.reverseTextButton)//Bind button to event handler
    public void doReverseText() {
        final String textInput = textInputEditText.getText().toString();
        final Context context = this;

        if(TextUtils.isEmpty(textInput)){
             textInputEditText.setError(getString(R.string.input_text_required));

        }else {

            if (NetworkConnectionStatus.isConnnected(context)) {//check for internet connectivity.
                try {
                    final ProgressDialog progressDialog = new ProgressDialog(context);
                    progressDialog.setMessage(getString(R.string.loading));
                    progressDialog.show();


                    final Map<String, String> inputReqquestMap = new HashMap<>();

                    inputReqquestMap.put("content", textInput);


                    final ApiEndpointInterface apiService = Config.getAPIService();
                    apiService.postToApi(inputReqquestMap).enqueue(new Callback<ResponseBody>() {
                        @Override
                        public void onResponse(Call<ResponseBody> call, Response<ResponseBody> response) {
                            progressDialog.dismiss();
                            int statusCode = response.code();

                            if (statusCode == 200 && response.isSuccessful()) {

                                try {
                                    final String body = response.body().string();
                                    //Log.i(TAG, body);

                                    JSONObject apiResponse = new JSONObject(body);


                                    String output = apiResponse.getString("output");
                                    textOutputTextView.setText(output);


                                } catch (IOException | JSONException e) {
                                    e.printStackTrace();
                                }


                            } else {
                                Toast.makeText(context, R.string.unexpected_error, Toast.LENGTH_LONG).show();
                            }

                        }

                        @Override
                        public void onFailure(Call<ResponseBody> call, Throwable t) {
                            progressDialog.dismiss();
                            Toast.makeText(context, R.string.unexpected_error, Toast.LENGTH_LONG).show();
                        }
                    });

                } catch (Exception e) {
                    e.printStackTrace();
                }
            } else {
                Toast.makeText(context, R.string.nointernetretry, Toast.LENGTH_LONG).show();
            }
        }

    }
}
