package com.pristalovpavel.in4mative;

import android.content.Context;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;

/**
 * A simple {@link Fragment} subclass.
 * Activities that contain this fragment must implement the
 * {@link OnDateTimeFragmentInteractionListener} interface
 * to handle interaction events.
 * Use the {@link DateTimeFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class DateTimeFragment extends Fragment {
    private OnDateTimeFragmentInteractionListener mListener;
    public DateTimeFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @return A new instance of fragment DateTimeFragment.
     */
    public static DateTimeFragment newInstance() {
        DateTimeFragment fragment = new DateTimeFragment();
        /*Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);*/
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            //mParam1 = getArguments().getString(ARG_PARAM1);
            //mParam2 = getArguments().getString(ARG_PARAM2);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_date_time, container, false);
    }

    public void onButtonPressed(Uri uri) {
        if (mListener != null) {
            mListener.onFragmentInteraction(uri);
        }
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        if (context instanceof OnDateTimeFragmentInteractionListener) {
            mListener = (OnDateTimeFragmentInteractionListener) context;
        } else {
            throw new RuntimeException(context.toString()
                    + " must implement OnDateTimeFragmentInteractionListener");
        }

    }

    @Override
    public void onResume()
    {
        super.onResume();
        //TODO test me on 14..16 API!!!
        if(Build.VERSION.SDK_INT < 17)
        {
            //TODO use data binding library instead
            if(getView() != null) {
                View dateView = getView().findViewById(R.id.dateView);
                if (dateView != null && dateView instanceof TextView) {
                    ((TextView) dateView).setText(DateFormat.getDateInstance(
                            DateFormat.SHORT).format(Calendar.getInstance()));
                }
            }
        }
    }
    @Override
    public void onDetach() {
        super.onDetach();
        mListener = null;
    }

    /**
     * This interface must be implemented by activities that contain this
     * fragment to allow an interaction in this fragment to be communicated
     * to the activity and potentially other fragments contained in that
     * activity.
     * <p>
     * See the Android Training lesson <a href=
     * "http://developer.android.com/training/basics/fragments/communicating.html"
     * >Communicating with Other Fragments</a> for more information.
     */
    public interface OnDateTimeFragmentInteractionListener {
        void onFragmentInteraction(Uri uri);
    }
}