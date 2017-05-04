package lania.com.mx.functional_android.views.fragments;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.DividerItemDecoration;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.List;

import lania.com.mx.functional_android.R;
import lania.com.mx.functional_android.data.InMemoryPersonRepository;
import lania.com.mx.functional_android.models.Person;
import lania.com.mx.functional_android.models.PersonRepository;
import lania.com.mx.functional_android.views.adapters.PersonAdapter;

/**
 * Created by moracl6 on 5/3/2017.
 */

public class PersonsFragment extends Fragment {
    public static PersonsFragment newInstance() {

        Bundle args = new Bundle();

        PersonsFragment fragment = new PersonsFragment();
        fragment.setArguments(args);
        return fragment;
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.person_fragment, container, false);
        displayPersons(rootView);
        return rootView;
    }

    private void displayPersons(View rootView) {
        final RecyclerView personsRecyclerView = (RecyclerView) rootView.findViewById(R.id.personsRecyclerView);

        PersonRepository repository = new InMemoryPersonRepository();
        List<Person> persons = repository.getAll();
        PersonAdapter adapter = new PersonAdapter(persons);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getActivity(),
                LinearLayoutManager.VERTICAL, false);
        linearLayoutManager.setAutoMeasureEnabled(true);
        personsRecyclerView.setNestedScrollingEnabled(false);
        personsRecyclerView.setAdapter(adapter);
        personsRecyclerView.setLayoutManager(linearLayoutManager);
        personsRecyclerView.setHasFixedSize(true);

        RecyclerView.ItemDecoration dividerItemDecoration = new DividerItemDecoration(getContext(), linearLayoutManager.getOrientation());
        personsRecyclerView.addItemDecoration(dividerItemDecoration);
    }
}
