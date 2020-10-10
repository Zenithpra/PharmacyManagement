package com.foodmandu.ui.home;

import android.os.Bundle;
import android.os.Handler;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.ViewFlipper;

import androidx.annotation.Nullable;
import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewpager.widget.ViewPager;

import com.foodmandu.R;
import com.foodmandu.ui.home.Adapter.CategoryAdapter;
import com.foodmandu.ui.home.Adapter.SuperAdapter;
import com.foodmandu.ui.home.Adapter.ViewPagerAdapter;
import com.foodmandu.ui.home.Model.SuperViewModel;

import java.util.ArrayList;
import java.util.List;

public class HomeFragment extends Fragment {

    // private HomeViewModel homeViewModel;
    private RecyclerView recyclerView;
    private RecyclerView SuperRecyclerView;
    ViewPager viewPager;
    public static List<HomeViewModel> categoryList=new ArrayList<>();
    public static List<SuperViewModel> superList=new ArrayList<>();
    private int position;
    private static final int PAGE_NUM=4;

    private Handler handler=new Handler();
    private Runnable runnable=new Runnable() {
        @Override
        public void run() {
            viewPager.setCurrentItem(position,true);
            if(position>=PAGE_NUM) position=0;
            else position++;
            handler.postDelayed(runnable,3000);
        }
    };

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_home, container, false);

        viewPager = view.findViewById(R.id.viewpager);
        ViewPagerAdapter viewPagerAdapter=new ViewPagerAdapter(getActivity());
        viewPager.setAdapter(viewPagerAdapter);
        runnable.run();



        recyclerView=view.findViewById(R.id.recycler);
        HomeViewModel homeViewModel=new HomeViewModel("foodmandu",R.drawable.food);
        categoryList=HomeViewModel.getListcategory();
        categoryList.add(new HomeViewModel("Restaurant",R.drawable.restaur));
        categoryList.add(new HomeViewModel("Liquors",R.drawable.daru));
        categoryList.add(new HomeViewModel("Bakeries",R.drawable.cake));
        categoryList.add(new HomeViewModel("Refreshment",R.drawable.history));
        categoryList.add(new HomeViewModel("Organic",R.drawable.notification));

        CategoryAdapter categoryAdapter=new CategoryAdapter(getActivity(),categoryList);
        recyclerView.setAdapter(categoryAdapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(getActivity(),LinearLayoutManager.HORIZONTAL,false));


        SuperRecyclerView=view.findViewById(R.id.recyclerSuper);
        SuperViewModel superViewModel=new SuperViewModel(R.drawable.basket,"Nimesh 3* Hotel","pizza","Gausala",R.drawable.one);
        superList=superViewModel.getSuperlist();
        superList.add(new SuperViewModel(R.drawable.coke,"Nimesh Cafe","Coffee","Ratopul",R.drawable.two));
        superList.add(new SuperViewModel(R.drawable.pizza,"Paudel Lounge","Burger","Kalopul",R.drawable.three));
        superList.add(new SuperViewModel(R.drawable.momo,"Nimesh Paudel Restro","MO:MO","Setopul",R.drawable.four));
        superList.add(new SuperViewModel(R.drawable.coke,"Paudel dai ko khaja ghar","Chiken Chilli","Nilopul",R.drawable.five));
        superList.add(new SuperViewModel(R.drawable.pizza,"Nimesh Hotel","Susege","Hariyopul",R.drawable.ic_menu_camera));
        SuperAdapter superAdapter=new SuperAdapter(getActivity(),superList);
        SuperRecyclerView.setAdapter(superAdapter);
        SuperRecyclerView.setLayoutManager(new LinearLayoutManager(getActivity(),LinearLayoutManager.HORIZONTAL,false));


        return view;

    }


}