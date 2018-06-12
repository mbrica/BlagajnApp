package com.example.marko.blagajnapp.ui.djelatnik_racun;

import android.app.AlertDialog;
import android.app.Dialog;
import android.graphics.pdf.PdfDocument;
import android.os.Bundle;
import android.os.Environment;
import android.print.PrintAttributes;
import android.print.pdf.PrintedPdfDocument;
import android.support.annotation.NonNull;
import android.support.v4.app.DialogFragment;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.example.marko.blagajnapp.R;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;

public class RacunDialog extends DialogFragment implements View.OnClickListener {

    private RelativeLayout rlRacun;
    private String naslov;
    private String racunId;
    private String vrijeme;
    private String djelatnik;
    private String stavkeRacuna;
    private String ukupno;
    private ClickListener clickListener;

    @NonNull
    @Override
    public Dialog onCreateDialog(Bundle savedInstanceState) {
        AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());
        LayoutInflater inflater = getActivity().getLayoutInflater();
        View dialogView = inflater.inflate(R.layout.dialog_racun,null);
        builder.setView(dialogView);
        setUpUI(dialogView);
        return builder.create();
    }

    public void setRacunId(String racunId){
        this.racunId = racunId;
    }

    public void setVrijeme (String vrijeme){
        this.vrijeme = vrijeme;
    }

    public void setDjelatnik (String djelatnik){
        this.djelatnik = djelatnik;
    }

    public void setStavkeRacuna (String stavkeRacuna){
        this.stavkeRacuna = stavkeRacuna;
    }

    public void setUkupno (String ukupno){
        this.ukupno = ukupno;
    }

    public  void setClickListener(ClickListener clickListener){
        this.clickListener = clickListener;
    }

    private void setUpUI(View dialogView){

        TextView tvNaslov = (TextView) dialogView.findViewById(R.id.tvNaslov);
        tvNaslov.setText("Račun");
        TextView tvRacun = (TextView) dialogView.findViewById(R.id.tvRacun);
        tvRacun.setText("Broj računa: " + racunId);
        TextView tvVrijeme = (TextView) dialogView.findViewById(R.id.tvVrijeme);
        tvVrijeme.setText("Vrijeme: " + "\n"+  vrijeme);
        TextView tvDjelatnik = (TextView) dialogView.findViewById(R.id.tvDjelatnik);
        tvDjelatnik.setText("Djelatnik: " + djelatnik);
        TextView tvStavke = (TextView) dialogView.findViewById(R.id.tvStavke);
        tvStavke.setText(stavkeRacuna);
        TextView tvUkupno = (TextView) dialogView.findViewById(R.id.tvUkupno);
        tvUkupno.setText(ukupno);

        TextView tvUredu = (TextView) dialogView.findViewById(R.id.tvUredu);
        tvUredu.setOnClickListener(this);
        TextView tvOdustani = (TextView) dialogView.findViewById(R.id.tvOdustani);
        tvOdustani.setOnClickListener(this);

        rlRacun = (RelativeLayout) dialogView.findViewById(R.id.rlRacun);
    }

    @Override
    public void onClick(View v) {
        if (v.getId() == R.id.tvOdustani){
            dismiss();
        } else if (v.getId() == R.id.tvUredu) {
            printPDF();
        }
    }

    public void printPDF(){
        if (isExternalStorageWritable()){
            String filename = String.valueOf(racunId + ".pdf");
            File dir = Environment.getExternalStoragePublicDirectory(Environment.DIRECTORY_DOCUMENTS);
            if (!dir.exists()){
                dir.mkdirs();
            }
            File file = new File(dir, filename);
            try {
                FileOutputStream outputStream = new FileOutputStream(file);
                createPDF(outputStream);
            } catch (IOException e) {
                e.printStackTrace();
                Toast.makeText(getContext(),e.getMessage(),Toast.LENGTH_SHORT).show();
            }
            dismiss();
        }
    }

    public static boolean isExternalStorageWritable(){
        String state = Environment.getExternalStorageState();
        if (Environment.MEDIA_MOUNTED.equals(state)) {
            return true;
        }
        return false;
    }

    private void createPDF (FileOutputStream outputStream) throws IOException{
        PrintAttributes.Builder builder = new PrintAttributes.Builder()
                .setMediaSize(PrintAttributes.MediaSize.ISO_A4)
                .setResolution(new PrintAttributes.Resolution("res1", "Resolution",50,50))
                .setMinMargins(new PrintAttributes.Margins(5,5,5,5));
        PrintedPdfDocument document = new PrintedPdfDocument(getContext(),builder.build());

        PdfDocument.Page page = document.startPage(1);

        rlRacun.draw(page.getCanvas());



        document.finishPage(page);

        document.writeTo(outputStream);

        document.close();

        if (clickListener != null)
            clickListener.onOkClick();
    }

    interface ClickListener {
        void onOkClick();
    }
}
