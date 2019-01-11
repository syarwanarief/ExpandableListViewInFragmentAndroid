package mobile.project.teknokitah.Menu;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ExpandableListView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.zip.Inflater;

import mobile.project.teknokitah.CustomeAdapter.ExpandableListViewAdapter;
import mobile.project.teknokitah.R;

public class FragmentLainnya extends Fragment {

    ExpandableListViewAdapter listViewAdapter;
    ExpandableListView expandableListView;
    List<String> listDataHeader;
    HashMap<String, List<String>> listDataChild;

    @Override
    public void onStart() {
        super.onStart();
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_lainnya, container,false);
        expandableListView = (ExpandableListView) view.findViewById(R.id.exListView);

        DaftarList();

        listViewAdapter = new ExpandableListViewAdapter(getActivity(), listDataHeader, listDataChild);

        expandableListView.setAdapter(listViewAdapter);

        expandableListView.setOnChildClickListener(new ExpandableListView.OnChildClickListener() {
            @Override
            public boolean onChildClick(ExpandableListView parent, View v, int groupPosition, int childPosition, long id) {

                if (listDataChild.get(listDataHeader.get(groupPosition)).get(childPosition) == "Teknik Informatika"){
                    Toast.makeText(getContext(),"teknik informatika",Toast.LENGTH_SHORT).show();
                }
                else if (listDataChild.get(listDataHeader.get(groupPosition)).get(childPosition) == "Sistem Informasi"){
                    Toast.makeText(getContext(),"Sistem Informasi",Toast.LENGTH_SHORT).show();
                }
                return false;
            }
        });
        return view;
    }

    private void DaftarList(){

        listDataHeader = new ArrayList<>();
        listDataChild = new HashMap<String, List<String>>();

        listDataHeader.add("Fakultas Teknik Dan Ilmu Komputer");
        listDataHeader.add("Fakultas Ekonomi Dan Bisnis");
        listDataHeader.add("Fakultas Sastra dan Ilmu Pendidikan");

        List<String> ftik = new ArrayList<String>();
        ftik.add("Teknik Informatika");
        ftik.add("Sistem Informasi");

        List<String> feb = new ArrayList<String>();
        feb.add("Ekonomi");
        feb.add("Ekonomi Bisnis");

        List<String> fsip = new ArrayList<String>();
        fsip.add("Sastra Inggris");
        fsip.add("Sastra Jepang");

        listDataChild.put(listDataHeader.get(0), ftik);
        listDataChild.put(listDataHeader.get(1), feb);
        listDataChild.put(listDataHeader.get(2), fsip);
    }

}
