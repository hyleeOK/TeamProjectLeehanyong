package edu.android.teamproject;


import android.app.DatePickerDialog;
import android.app.Dialog;
import android.content.Context;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v4.app.DialogFragment;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.DatePicker;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Calendar;

/**
 * A simple {@link Fragment} subclass.
 * 출발날짜를 저장하고 있는 다이얼로그
 */
public class DataFragment extends DialogFragment implements
    DatePickerDialog.OnDateSetListener {


    public interface DataSelectListener{
        void dataSelected(int year, int mouth, int dayOfMouth);
//        void dataSelectedEnd(int year, int mouth, int dayOfMouth);
    }


    private DataSelectListener listener;

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        if(context instanceof AirPlaneActivity){
            listener = (DataSelectListener) context;
        }
    }

    @Override
    public void onDetach() {
        super.onDetach();
        listener = null;
    }

    public DataFragment() {
        // Required empty public constructor
    }

    @NonNull
    @Override
    public Dialog onCreateDialog(Bundle savedInstanceState) {
        // 현재 시간 정보
        Calendar cal = Calendar.getInstance();
        // 현재 날짜 정보
        int year = cal.get(Calendar.YEAR);
        int mouth = cal.get(Calendar.MONTH);
        int dayOfMonth = cal.get(Calendar.DAY_OF_MONTH);

        DatePickerDialog dlg = new DatePickerDialog(getContext(),
                this, year, mouth, dayOfMonth);

        DatePickerDialog dlg2 = new DatePickerDialog(getContext(),
                this, year, mouth, dayOfMonth);

//            DatePicker에서 날짜를 선택했을 떄 호출되는 리스너(기능)

        return dlg;


    }

    @Override
    public void onDateSet(DatePicker datePicker, int year, int mouth, int dayOfMonth) {

        Toast.makeText(getContext(), year + " / " + (mouth+1) + " / " + dayOfMonth
                , Toast.LENGTH_SHORT).show();

        if(listener !=null){
            listener.dataSelected(year, mouth, dayOfMonth);
        }
    }






}
