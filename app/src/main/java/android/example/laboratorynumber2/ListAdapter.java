package android.example.laboratorynumber2;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

import com.bumptech.glide.Glide;

import java.util.ArrayList;
import java.util.zip.Inflater;

public class ListAdapter extends BaseAdapter {
    private ArrayList<Civilisation> arrayList;
    private Context context;
    ImageView Image;
    TextView nameOfTechnology;
    TextView descriptionOfTechnology;

    public ListAdapter(ArrayList<Civilisation> arrayList, Context context) {
        this.arrayList = arrayList;
        this.context = context;

    }

    @Override
    public int getCount() {
        return arrayList.size()-1;
    }

    @Override
    public Object getItem(int i) {
        return arrayList.get(i);
    }

    @Override
    public long getItemId(int i) {
        return i;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        LayoutInflater lInflater = (LayoutInflater) context
                .getSystemService(Context.LAYOUT_INFLATER_SERVICE);

        View view1 = view;
        if (view == null) {
            view = lInflater.inflate(R.layout.list_item, viewGroup, false);
        }
        Image = view.findViewById(R.id.ImageItem);
        nameOfTechnology=view.findViewById(R.id.nameText);
        descriptionOfTechnology = view.findViewById(R.id.descriptionText);
        Civilisation object = arrayList.get(i);
        descriptionOfTechnology.setText(object.getDescription());
        nameOfTechnology.setText(object.getName());
        Glide
                .with(context)
                .load(object.getImage())
                .into(Image);
        return view;
    }
}
