package com.example.login;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.app.Dialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class LoginPage extends AppCompatActivity {

    EditText edten, eduser,edpassword,edconfirm;
    Button btnDangNhap, btndangky, btnthoat;
    String ten,mk;

    private boolean CheckUser(String username, String password) {
        // TODO: Replace with actual production code
        if (username.equals("admin") && password.equals("123")) {
            return true;
        }

        if (username.equals(ten) && password.equals(mk)) {
            return true;
        }

        return false;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.dang_nhap);
        Anhxa();
        ControlButton();
    }

    private void ControlButton() {
        btnthoat.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                AlertDialog.Builder builder = new AlertDialog.Builder(LoginPage.this, android.R.style.Theme_DeviceDefault_Light_Dialog);
                builder.setTitle("Bạn có chắc muốn thoát khỏi app");
                builder.setMessage("Hãy lựa chọn bên dưới để xác nhận");
                builder.setIcon(android.R.drawable.ic_dialog_alert);
                builder.setPositiveButton("Có", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        onBackPressed();
                    }
                });
                builder.setNegativeButton("Không", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {

                    }
                });
                builder.show();
            }
        });

        btndangky.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Dialog dialog = new Dialog(LoginPage.this);
                dialog.setTitle("Hộp thoại xử lý ");
                dialog.setCancelable(false);
                dialog.setContentView(R.layout.dang_ky);
                EditText edttk = (EditText) dialog.findViewById(R.id.edttk);
                EditText edtmk = (EditText) dialog.findViewById(R.id.edtmk);
                Button btnhuy = (Button) dialog.findViewById(R.id.buttonhuy);
                Button btndongy = (Button) dialog.findViewById((R.id.buttondongy));
                btndongy.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        ten = edttk.getText().toString().trim();
                        mk = edtmk.getText().toString().trim();

                        eduser.setText(ten);
                        edpassword.setText(mk);

                        dialog.cancel();
                    }
                });
                btnhuy.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        dialog.cancel();
                    }
                });
                dialog.show();
            }
        });
        btnDangNhap.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (eduser.getText().length() <= 0 || edpassword.getText().length() <= 0) {
                    Toast.makeText(LoginPage.this, "Mời bạn nhập đủ thông tin", Toast.LENGTH_SHORT).show();
                }

                boolean ok = CheckUser(
                        eduser.getText().toString().trim(),
                        edpassword.getText().toString().trim()
                );

                if (ok) {
                    Toast.makeText(LoginPage.this, "Bạn đã đăng nhập thành công", Toast.LENGTH_SHORT).show();
                    Intent intent = new Intent(LoginPage.this, MainNav.class);
                    startActivity(intent);
                } else {
                    Toast.makeText(LoginPage.this, "Bạn đã đăng nhập thất bại", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }

    private void Anhxa() {
        edten = (EditText) findViewById(R.id.edtten);
        eduser = (EditText) findViewById(R.id.edittextuser);
        edpassword = (EditText) findViewById(R.id.edittextpassword);
        edconfirm = (EditText)findViewById(R.id.edtconfirm);
        btnDangNhap = (Button) findViewById(R.id.buttondangnhap);
        btndangky = (Button) findViewById(R.id.buttondangky);
        btnthoat = (Button) findViewById(R.id.buttonthoat);
    }
}