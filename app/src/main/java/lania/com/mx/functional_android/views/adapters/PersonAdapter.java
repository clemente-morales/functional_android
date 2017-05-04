package lania.com.mx.functional_android.views.adapters;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.List;

import lania.com.mx.functional_android.R;
import lania.com.mx.functional_android.models.Person;

/**
 * Created by moracl6 on 5/3/2017.
 */

public class PersonAdapter extends RecyclerView.Adapter<PersonAdapter.MainHolder> {

    private final List<Person> persons;

    public PersonAdapter(List<Person> persons) {
        this.persons = persons;
    }

    @Override
    public MainHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.person_row, parent, false);
        return new MainHolder(view);
    }

    @Override
    public void onBindViewHolder(MainHolder holder, int position) {
        Person person = persons.get(position);
        holder.personNameTextView.setText(person.getFullName());
        holder.cityTextView.setText(person.getCity().getName());
    }

    @Override
    public int getItemCount() {
        return persons.size();
    }

    public class MainHolder extends RecyclerView.ViewHolder {
        private TextView cityTextView;
        private TextView personNameTextView;

        public MainHolder(View itemView) {
            super(itemView);
            cityTextView = (TextView) itemView.findViewById(R.id.cityTextView);
            personNameTextView = (TextView) itemView.findViewById(R.id.personNameTextView);
        }
    }
}
