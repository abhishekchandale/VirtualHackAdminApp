package com.example.abhishekchandale.virtualhackadminapp.adapter;

import android.content.Context;
import android.content.Intent;
import android.database.Cursor;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.media.Image;
import android.util.Base64;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.abhishekchandale.virtualhackadminapp.R;
import com.example.abhishekchandale.virtualhackadminapp.database.DbAccess;
import com.example.abhishekchandale.virtualhackadminapp.ui.RegisterRequest;
import com.example.abhishekchandale.virtualhackadminapp.ui.ResponseMail;

import java.util.LinkedList;

/**
 * Created by admi on 9/9/15.
 */
public class ComplaintAdapter extends BaseAdapter {

    String[] compMessage;
    String[] compname;
    String[] compDate;
    Context context;
    boolean[] animationStates;
    private static LayoutInflater layoutInflater = null;
    private LinkedList<Integer> selectedIndeces = null;
    byte[][] compImage;

    public ComplaintAdapter(RegisterRequest pComp, String[] compMessageList, String[] applicationName, String[] name, byte[][] imageArray) {

        animationStates = new boolean[100];
        compMessage = compMessageList;
        context = pComp;
        compDate = applicationName;
        compname = name;
        compImage = imageArray;
        selectedIndeces = new LinkedList<>();
        layoutInflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        notifyDataSetChanged();
    }

    public void changeSelectedPositions(int pos) {
        int index = this.selectedIndeces.indexOf(pos);
        if (index != -1) {
            // image button in this row was selected
            this.selectedIndeces.remove(index);
        } else {
            // mark position of the image button as selected
            this.selectedIndeces.add(pos);
        }
        notifyDataSetChanged();
    }

    @Override
    public int getCount() {
        return compMessage.length;
    }

    @Override
    public Object getItem(int position) {
        return position;
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    public class Holder {

        TextView compMessage;
        TextView compDate;
        ImageView img;
        Button sendmail;
        TextView compName;
        //ImageButton lockBtn;
    }

    @Override
    public View getView(final int position, View convertView, ViewGroup parent) {
        final Holder holder = new Holder();
        View rowView;
        rowView = layoutInflater.inflate(R.layout.previous_comp_row, null);
        holder.compMessage = (TextView) rowView.findViewById(R.id.txt_card_comp_message);
        holder.img = (ImageView) rowView.findViewById(R.id.img_card);
        holder.compDate = (TextView) rowView.findViewById(R.id.txt_card_date);
        holder.sendmail = (Button) rowView.findViewById(R.id.txt_send_response);
        holder.compName = (TextView) rowView.findViewById(R.id.txt_card_username);
        Bitmap bmp = BitmapFactory.decodeByteArray(compImage[position], 0, compImage[position].length);
        holder.img.setImageBitmap(bmp);
        holder.compMessage.setText("ComplaintRequest:" + compMessage[position]);
        holder.compDate.setText("Date of complaint:" + compDate[position]);
        holder.compName.setText("Name:" + compname[position]);
        holder.sendmail.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                context.startActivity(new Intent(context, ResponseMail.class));
            }
        });

        Animation animation = null;
        animation = AnimationUtils.loadAnimation(context, R.anim.pushup_in);
        animation.setDuration(500);
        rowView.startAnimation(animation);
        animation = null;
        return rowView;
    }

    public void convertImage(String encodeImage) {


    }

}//
