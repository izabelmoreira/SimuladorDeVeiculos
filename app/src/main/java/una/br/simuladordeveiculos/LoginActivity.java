package una.br.simuladordeveiculos;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class LoginActivity extends Activity {

    private EditText edtNome;
    private EditText edtEmail;
    private Button btnEntrar;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        edtNome = findViewById(R.id.edtNome);
        edtEmail = findViewById(R.id.edtEmail);
        btnEntrar = findViewById(R.id.btnEntrar);

        btnEntrar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String nome;
                String email;

                nome = edtNome.getText().toString();
                email = edtEmail.getText().toString();

                if (nome.isEmpty()) {
                    Toast.makeText(LoginActivity.this, "Nome não encontrado", Toast.LENGTH_SHORT).show();
                    return;
                }

                if (email.isEmpty()) {
                    Toast.makeText(LoginActivity.this, "Email não encontrado", Toast.LENGTH_SHORT).show();
                }

                Intent intent = new Intent(LoginActivity.this, SelecionarVeiculoActivity.class);
                intent.putExtra("nome", nome);
                intent.putExtra("email", email);
                startActivity(intent);
            }
        });
    }
}
