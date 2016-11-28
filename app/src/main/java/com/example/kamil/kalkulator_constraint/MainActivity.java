package com.example.kamil.kalkulator_constraint;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    private CharSequence memory = "0";

    private void addToScreen(String s, TextView screen) {

        CharSequence text = screen.getText();
        if (text.length() == 1 && text.charAt(0) == '0') {

            screen.setText("");

        }

        String nowy_text = screen.getText() + s;
        screen.setText(nowy_text);

    }

    private void pokazNazwisko() {

        Toast.makeText(getApplicationContext(), "Kamil Dydo", Toast.LENGTH_SHORT).show();

    }

    private void deleteOne(TextView screen) {

        CharSequence text = screen.getText();

        if (text.length() == 1) {

            screen.setText("0");

        } else if (screen.getText().length() > 0) {

            screen.setText(text.subSequence(0, text.length() - 1));

        }

        text = screen.getText();

        if (text.charAt(0) == '-' && text.length() == 1) {

            screen.setText("0");

        }

    }

    private void dodaj_operator(TextView screen, char operator) {

        Character last = screen.getText().charAt(screen.getText().length() - 1);

        if (last == '-') {

            screen.setText(screen.getText().subSequence(0,
                    screen.getText().length() - 1));
            screen.append("+");
            return;

        }

        if (last.toString().matches("[*/+%-]")) {

            screen.setText(screen.getText().subSequence(0,
                    screen.getText().length() - 1));

        }

        screen.append("" + operator);

    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        final Button button_0 = (Button) findViewById(R.id.button_0);
        final Button button_1 = (Button) findViewById(R.id.button_1);
        final Button button_2 = (Button) findViewById(R.id.button_2);
        final Button button_3 = (Button) findViewById(R.id.button_3);
        final Button button_4 = (Button) findViewById(R.id.button_4);
        final Button button_5 = (Button) findViewById(R.id.button_5);
        final Button button_6 = (Button) findViewById(R.id.button_6);
        final Button button_7 = (Button) findViewById(R.id.button_7);
        final Button button_8 = (Button) findViewById(R.id.button_8);
        final Button button_9 = (Button) findViewById(R.id.button_9);
        final Button button_przecinek = (Button) findViewById(R.id.button_przecinek);
        final Button button_eq = (Button) findViewById(R.id.button_eq);
        final Button button_plus = (Button) findViewById(R.id.button_plus);
        final Button button_minus = (Button) findViewById(R.id.button_minus);
        final Button button_iloczyn = (Button) findViewById(R.id.button_iloczyn);
        final Button button_div = (Button) findViewById(R.id.button_div);
        final Button button_mplus = (Button) findViewById(R.id.button_mplus);
        final Button button_mr = (Button) findViewById(R.id.button_mr);
        final Button button_mc = (Button) findViewById(R.id.button_mc);
        final Button button_c = (Button) findViewById(R.id.button_c);
        final Button button_procent = (Button) findViewById(R.id.button_procent);
        final Button button_znak = (Button) findViewById(R.id.button_znak);
        final Button button_del = (Button) findViewById(R.id.button_del);
        final TextView wyswietlacz = (TextView) findViewById(R.id.wyswietlacz);
        final TextView historia = (TextView) findViewById(R.id.historia);


        button_0.setOnClickListener(new View.OnClickListener() {

            public void onClick(View v) {

                addToScreen("0", historia);

            }

        });

        button_1.setOnClickListener(new View.OnClickListener() {

            public void onClick(View v) {

                addToScreen("1", historia);

            }

        });

        button_2.setOnClickListener(new View.OnClickListener() {

            public void onClick(View v) {

                addToScreen("2", historia);

            }

        });

        button_3.setOnClickListener(new View.OnClickListener() {

            public void onClick(View v) {

                addToScreen("3", historia);

            }

        });

        button_4.setOnClickListener(new View.OnClickListener() {

            public void onClick(View v) {

                addToScreen("4", historia);

            }

        });

        button_5.setOnClickListener(new View.OnClickListener() {

            public void onClick(View v) {

                addToScreen("5", historia);

            }

        });

        button_6.setOnClickListener(new View.OnClickListener() {

            public void onClick(View v) {

                addToScreen("6", historia);

            }

        });

        button_7.setOnClickListener(new View.OnClickListener() {

            public void onClick(View v) {

                addToScreen("7", historia);

            }

        });

        button_8.setOnClickListener(new View.OnClickListener() {

            public void onClick(View v) {

                addToScreen("8", historia);

            }

        });

        button_9.setOnClickListener(new View.OnClickListener() {

            public void onClick(View v) {

                addToScreen("9", historia);

            }

        });

        button_del.setOnClickListener(new View.OnClickListener() {

            public void onClick(View v) {

                deleteOne(historia);

            }

        });

        button_przecinek.setOnClickListener(new View.OnClickListener() {

            public void onClick(View v) {

                CharSequence text = historia.getText();

                String[] operandy = text.toString().split("[-+*/%]");
                String ostatni = operandy[operandy.length - 1];
                if (!ostatni.contains(".")) {

                    historia.append(".");

                }

            }

        });

        button_znak.setOnClickListener(new View.OnClickListener() {

            public void onClick(View w) {

                CharSequence text = wyswietlacz.getText();

                if (text.charAt(0) != '0' || text.length() > 1) {

                    if (text.toString().indexOf('-') != -1) {

                        wyswietlacz.setText(text.subSequence(1, text.length()));

                    } else {

                        String nowy_text = "-" + text.toString();
                        wyswietlacz.setText(nowy_text);

                    }

                }

            }

        });

        button_c.setOnClickListener(new View.OnClickListener() {

            public void onClick(View w) {

                historia.setText("0");
                wyswietlacz.setText("0");

            }

        });

        button_mplus.setOnClickListener(new View.OnClickListener() {

            public void onClick(View w) {

                memory = wyswietlacz.getText();

            }

        });

        button_mr.setOnClickListener(new View.OnClickListener() {

            public void onClick(View w) {

                wyswietlacz.setText(memory);

            }

        });

        button_mc.setOnClickListener(new View.OnClickListener() {

            public void onClick(View w) {

                memory = "0";

            }

        });

        button_plus.setOnClickListener(new View.OnClickListener() {

            public void onClick(View w) {

                dodaj_operator(historia, '+');

            }

        });

        button_minus.setOnClickListener(new View.OnClickListener() {

            public void onClick(View w) {

                dodaj_operator(historia, '-');

            }

        });

        button_div.setOnClickListener(new View.OnClickListener() {

            public void onClick(View w) {

                dodaj_operator(historia, '/');
            }

        });

        button_iloczyn.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {

                dodaj_operator(historia, '*');

            }

        });

        button_procent.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {

                dodaj_operator(historia, '%');

            }

        });

        button_eq.setOnClickListener(new View.OnClickListener() {

            public void onClick(View w) {

                String text = historia.getText().toString();
                String[] operandy = text.split("[-+*/%]");
                for (int i = 0; i < operandy.length; i++)
                    if (operandy[i].equals("."))
                        operandy[i] = "0";

                char[] operacje = text.replaceAll("[^-+*/%]", "").toCharArray();
                ArrayList<Double> operandy_double = new ArrayList<Double>();

                for (String operand : operandy)
                    operandy_double.add(Double.parseDouble(operand));

                Double wynik = operandy_double.get(0);

                try {

                    for (int i = 0; i < operacje.length; i++) {

                        switch (operacje[i]) {

                            case '+':
                                wynik += operandy_double.get(i + 1);
                                break;
                            case '-':
                                wynik -= operandy_double.get(i + 1);
                                break;
                            case '/':
                                if (operandy_double.get(i + 1) == 0) {

                                    throw new IllegalArgumentException();

                                }
                                wynik /= operandy_double.get(i + 1);
                                break;
                            case '*':
                                wynik *= operandy_double.get(i + 1);
                                break;
                            case '%':
                                wynik %= operandy_double.get(i + 1);
                                break;

                        }

                    }

                    String wynik_str = wynik.toString();
                    wyswietlacz.setText(wynik_str);

                } catch (IllegalArgumentException e) {

                    Toast.makeText(getApplicationContext(),
                            "Zakaz dzielenia przez zero!",
                            Toast.LENGTH_SHORT).show();

                } catch (Exception e) {

                    Toast.makeText(getApplicationContext(),
                            "Niepoprawne argumenty.",
                            Toast.LENGTH_SHORT).show();

                }

            }

        });

        wyswietlacz.setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View v) {
                pokazNazwisko();
                return true;
            }
        });

        historia.setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View v) {
                pokazNazwisko();
                return true;
            }
        });


    }

}
