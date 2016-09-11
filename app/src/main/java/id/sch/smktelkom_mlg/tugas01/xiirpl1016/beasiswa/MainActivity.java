package id.sch.smktelkom_mlg.tugas01.xiirpl1016.beasiswa;

import android.content.DialogInterface;
import android.os.Bundle;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Spinner;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    EditText etNISN;
    EditText etNama;
    EditText etTempatLahir;

    Spinner spTanggal, spBulan, spTahun;
    RadioGroup rgKelamin;

    CheckBox cbAyah, cbIbu, cbAdik, cbKakak;

    TextView tvHasil;
    Button bOK;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        setContentView(R.layout.activity_main);
        etNISN = (EditText) findViewById(R.id.editTextNISN);
        etNama = (EditText) findViewById(R.id.editTextNama);
        etTempatLahir = (EditText) findViewById(R.id.editTextTempatLahir);
        spTanggal = (Spinner) findViewById(R.id.spinnerTanggal);
        spBulan = (Spinner) findViewById(R.id.spinnerBulan);
        spTahun = (Spinner) findViewById(R.id.spinnerTahun);
        rgKelamin = (RadioGroup) findViewById(R.id.radioGroupKelamin);
        cbAyah = (CheckBox) findViewById(R.id.checkBoxAyah);
        cbIbu = (CheckBox) findViewById(R.id.checkBoxIbu);
        cbAdik = (CheckBox) findViewById(R.id.checkBoxKakak);
        cbKakak = (CheckBox) findViewById(R.id.checkBoxKakak);

        tvHasil = (TextView) findViewById(R.id.textViewHasil);

        bOK = (Button) findViewById(R.id.buttonOK);

        bOK.setOnClickListener(new View.OnClickListener() {
                                   @Override
                                   public void onClick(View view) {
                                       doProcess();
                                   }
                               }
        );

    }

    private void doProcess() {
        if (isValid()) {
            int NISN = Integer.parseInt(etNISN.getText().toString());
            String nama = etNama.getText().toString();
            String tempatLahir = etTempatLahir.getText().toString();


            String tanggal = spTanggal.getSelectedItem().toString();
            String bulan = spBulan.getSelectedItem().toString();
            String tahun = spTahun.getSelectedItem().toString();
            String kelamin = null;
            AlertDialog alertDialog = new AlertDialog.Builder(MainActivity.this).create();
            alertDialog.setTitle("Perhatian!");
            alertDialog.setMessage("Mohon isi jenis kelamin anda");
            alertDialog.setButton(AlertDialog.BUTTON_NEUTRAL, "OK", new DialogInterface.OnClickListener() {
                public void onClick(DialogInterface dialog, int which) {
                    dialog.dismiss();
                }
            });
            String Combobox = "\n Keluarga yang masih hidup\t\t\t\t:\n";
            int startlen = Combobox.length();
            if (cbAyah.isChecked()) {
                Combobox += " - " + cbAyah.getText() + "\n";
            }
            if (cbIbu.isChecked()) {
                Combobox += " - " + cbIbu.getText() + "\n";
            }
            if (cbKakak.isChecked()) {
                Combobox += " - " + cbKakak.getText() + "\n";
            }
            if (cbAdik.isChecked()) {
                Combobox += " - " + cbAdik.getText() + "\n";
            }

            if (Combobox.length() == startlen) {
                Combobox += "Tidak ada dalam pilihan";
            }

            if (rgKelamin.getCheckedRadioButtonId() != -1) {
                RadioButton rb = (RadioButton)
                        findViewById(rgKelamin.getCheckedRadioButtonId());
                kelamin = rb.getText().toString();
            }

            if (kelamin == null) {
                alertDialog.show();
            } else {
                tvHasil.setText(" DATA ANDA :\n\n NISN\t\t\t\t\t\t\t\t\t\t\t: " + NISN + "\n Nama\t\t\t\t\t\t\t\t\t\t: " + nama + "\n Tempat Lahir\t\t\t\t: " + tempatLahir + "\n Tanggal Lahir\t\t\t\t: " + tanggal + " " + bulan + " " + tahun + "\n Jenis Kelamin\t\t\t\t: " + kelamin + Combobox);
            }


        }
    }

    private boolean isValid() {
        boolean valid = true;
        String NISN = etNISN.getText().toString();
        String nama = etNama.getText().toString();
        String tempatLahir = etTempatLahir.getText().toString();


        if (NISN.isEmpty()) {
            etNISN.setError("NISN belum diisi");
            valid = false;
        } else {
            etNISN.setError(null);
        }

        if (nama.isEmpty()) {
            etNama.setError("Nama belum diisi");
            valid = false;
        } else {
            etNama.setError(null);
        }

        if (tempatLahir.isEmpty()) {
            etTempatLahir.setError("Tempat lahir belum diisi");
            valid = false;
        } else {
            etTempatLahir.setError(null);
        }
        return valid;
    }
}
