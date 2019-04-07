package android.example.laboratorynumber2;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.constraint.ConstraintLayout;
import android.support.v4.view.PagerAdapter;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.bumptech.glide.Glide;

import java.util.ArrayList;

public class MyViewPagerAdapter extends PagerAdapter {
    private ImageView Image;
    private TextView name;
    private TextView description;

    private Context context;
    private ArrayList<Civilisation> arrayList;

    public MyViewPagerAdapter(ArrayList<Civilisation> arrayList, Context context1) {
        this.arrayList = arrayList;
        this.context = context1;
    }

    @Override
    public int getCount() {
        return arrayList.size() - 1;
    }

    @NonNull
    @Override
    public Object instantiateItem(@NonNull ViewGroup container, int position) {
        LayoutInflater lInflater = (LayoutInflater) context
                .getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View view = lInflater.inflate(R.layout.slide, container, false);
        LinearLayout layoutSlide = (LinearLayout) view.findViewById(R.id.viewPager);
        Image = view.findViewById(R.id.slide_image);
        name=view.findViewById(R.id.slide_name);
        description = view.findViewById(R.id.slide_description);
        Civilisation object = arrayList.get(position);
        description.setText(object.getDescription());
        name.setText(object.getName());
        Glide
                .with(context)
                .load(object.getImage())
                .into(Image);

        container.addView(view);
        return view;
    }

    @Override
    public void destroyItem(@NonNull ViewGroup container, int position, @NonNull Object object) {
        container.removeView((ConstraintLayout)object);
    }

    @Override
    public boolean isViewFromObject(@NonNull View view, @NonNull Object o) {
        return (view == (ConstraintLayout)o);
    }
}
