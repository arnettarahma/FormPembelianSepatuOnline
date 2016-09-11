package id.sch.smktelkom_mlg.tugas01.xirpl4008.formpembeliansepatuonline;

import android.os.Bundle;
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
    TextView tvTitle, tvJenis, tvNosep, tvCP, tvHasil;
    EditText etNama, etNotel, etAlamat, etKodePos, etKodeSepatu;
    Spinner spJenisSepatu;
    CheckBox cb36, cb37, cb38, cb39, cb40, cb41, cb42;
    RadioGroup rgCP;
    RadioButton rbBCA, rbBNI, rbMandiri, rbCOD;
    Button btnBeli;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        tvTitle = (TextView) findViewById(R.id.tvTitle);
        tvJenis = (TextView) findViewById(R.id.tvJenis);
        tvNosep = (TextView) findViewById(R.id.tvNosep);
        tvCP = (TextView) findViewById(R.id.tvCP);
        tvHasil = (TextView) findViewById(R.id.tvHasil);
        etNama = (EditText) findViewById(R.id.etNama);
        etNotel = (EditText) findViewById(R.id.etNotel);
        etAlamat = (EditText) findViewById(R.id.etAlamat);
        etKodeSepatu = (EditText) findViewById(R.id.etKodeSepatu);
        etKodePos = (EditText) findViewById(R.id.etKodePos);
        spJenisSepatu = (Spinner) findViewById(R.id.spJenisSepatu);
        cb36 = (CheckBox) findViewById(R.id.cb36);
        cb37 = (CheckBox) findViewById(R.id.cb37);
        cb38 = (CheckBox) findViewById(R.id.cb38);
        cb39 = (CheckBox) findViewById(R.id.cb39);
        cb40 = (CheckBox) findViewById(R.id.cb40);
        cb41 = (CheckBox) findViewById(R.id.cb41);
        cb42 = (CheckBox) findViewById(R.id.cb42);
        rgCP = (RadioGroup) findViewById(R.id.rgCP);
        rbBCA = (RadioButton) findViewById(R.id.rbBCA);
        rbBNI = (RadioButton) findViewById(R.id.rbBNI);
        rbMandiri = (RadioButton) findViewById(R.id.rbMandiri);
        rbCOD = (RadioButton) findViewById(R.id.rbCOD);
        btnBeli = (Button) findViewById(R.id.btnBeli);

        findViewById(R.id.btnBeli).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                doClick();
            }
        });
    }

    private void doClick() {
        String hasil = "Anda telah berhasil melakukan transaksi beli sepatu jenis " + spJenisSepatu.getSelectedItem().toString() +
                " dengan kode sepatu " + etKodeSepatu.getText().toString() + " ukuran ";
        int starlen = hasil.length();
        if (cb36.isChecked()) hasil += cb36.getText() + " ,";
        if (cb37.isChecked()) hasil += cb37.getText() + " ,";
        if (cb38.isChecked()) hasil += cb38.getText() + " ,";
        if (cb39.isChecked()) hasil += cb39.getText() + " ,";
        if (cb40.isChecked()) hasil += cb40.getText() + " ,";
        if (cb41.isChecked()) hasil += cb41.getText() + " ,";
        if (cb42.isChecked()) hasil += cb42.getText() + " ,";
        if (hasil.length() == starlen) hasil += "Tidak ada pada pilihan";

        tvHasil.setText(hasil);

        if (isValid()) {
        }
    }

    private boolean isValid() {
        boolean valid = true;

        String nama = etNama.getText().toString();
        String alamat = etAlamat.getText().toString();
        String kodepos = etKodePos.getText().toString();
        String notel = etNotel.getText().toString();
        String kodesepatu = etKodeSepatu.getText().toString();

        if (nama.isEmpty()) {
            etNama.setError("Nama belum diisi");
            valid = false;
        } else if (nama.length() < 3) {
            etNama.setError("Pastikan nama lengkap anda benar");
            valid = false;
        } else {
            etNama.setError(null);
        }

        if (alamat.isEmpty()) {
            etAlamat.setError("Alamat belum diisi");
            valid = false;
        } else if (alamat.length() < 8) {
            etAlamat.setError("Pastikan alamat lengkap anda benar");
            valid = false;
        } else {
            etAlamat.setError(null);
        }

        if (kodepos.isEmpty()) {
            etKodePos.setError("Kode pos belum diisi");
            valid = false;
        } else if (kodepos.length() != 5) {
            etKodePos.setError("Pastikan kode pos anda 5 digit");
            valid = false;
        } else {
            etKodePos.setError(null);
        }

        if (notel.isEmpty()) {
            etNotel.setError("Nomor telepon anda belum diisi");
            valid = false;
        } else {
            etNotel.setError(null);
        }

        if (kodesepatu.isEmpty()) {
            etKodeSepatu.setError("Kode sepatu yang ingin anda beli belum diisi");
            valid = false;
        } else {
            etKodeSepatu.setError(null);
        }
        return valid;
    }
}
