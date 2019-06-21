# App-with-Multiple-Language
Android example application for implementation of multiple language.

This project is for beginners. It is an example for how to implement multiple languages as options. For this example, language like English, Chinese, French, Hindi, Kannada and Spanish included.

<b>Steps to follow:</b>
<br>1. Create a new project
<br>2. Create new value directories for different languages like value-b-es(for spanish). Format value-b+<language code>.
<br>3. Create new strings.xml for each in directories with translated string item.
<br>4. Create a new activity for changing language and use the following snippet.
<br>public class ChangeLanguageActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_change_language);

        final Spinner spinner = findViewById(R.id.spinner);

        //get current locale language
        String cLang = getResources().getConfiguration().locale.getLanguage();

        //set selected position for the current language in spinner
        switch (cLang){
            case "en": spinner.setSelection(0); break;
            case "zh": spinner.setSelection(1); break;
            case "fr": spinner.setSelection(2); break;
            case "hi": spinner.setSelection(3); break;
            case "kn": spinner.setSelection(4); break;
            case "es": spinner.setSelection(5); break;
        }

        Button applyBtn = findViewById(R.id.applyBtn);
        applyBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int i = spinner.getSelectedItemPosition();
                setLanguage(i);
            }
        });
    }

    /**
     * method for updating locale config
     * @param item
     */
    private void setLanguage(int item){
        String lang;
        switch (item){
            case 0:lang = "en"; break;//set language as english
            case 1:lang = "zh"; break;//set language as chinese
            case 2:lang = "fr"; break;//set language as french
            case 3:lang = "hi"; break;//set language as hindi
            case 4:lang = "kn"; break;//set language as kannada
            case 5:lang = "es"; break;//set language as spanish
            default: lang = "en"; //set english as default english
        }

        //create new locale with selected language
        Locale myLocale = new Locale(lang);
        //get app resources
        Resources res = getResources();
        DisplayMetrics dm = res.getDisplayMetrics();
        Configuration conf = res.getConfiguration();
        conf.locale = myLocale;
        //update with new config
        res.updateConfiguration(conf, dm);
        //refresh or restart the main activity
        startActivity(new Intent(this, MainActivity.class));
        //finish the current activity
        finish();
    }
}

<br>For more details see the project.
<br>Happy Coding.
