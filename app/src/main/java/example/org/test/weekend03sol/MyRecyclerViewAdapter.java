package example.org.test.weekend03sol;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;

import java.util.ArrayList;

public class MyRecyclerViewAdapter extends RecyclerView.Adapter<MyRecyclerViewAdapter.ViewHolder> {

    ArrayList<Employee> employeeArrayList;

    public MyRecyclerViewAdapter(ArrayList<Employee> employeeArrayList) {
        this.employeeArrayList = employeeArrayList;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int position) {
        return new ViewHolder(LayoutInflater.from(viewGroup.getContext())
        .inflate(R.layout.employee_item, viewGroup, false));
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder viewHolder, final int position) {
        Employee currentEmployeeBeingPopulates = employeeArrayList.get(position);

        viewHolder.tvEmployeeName.setText(currentEmployeeBeingPopulates.getEmployeeImage());
        viewHolder.tvEmployeeBirth.setText(currentEmployeeBeingPopulates.getEmployeeBirthDate());
        viewHolder.tvEmployeeWage.setText(currentEmployeeBeingPopulates.getEmployeeWage());
        viewHolder.tvEmployeeHire.setText(currentEmployeeBeingPopulates.getEmployeeHireDate());
        Glide
                .with(viewHolder.itemView.getContext())
                .load("https://images.freeimages.com/images/large-previews/25d/eagle-1523807.jpg").into(viewHolder.imgEmployeeImage);

        Log.d("TAG", "onBindViewHolder: item being rendered = " + position);

       }
       public void addEmployeeToList(Employee employee){
        employeeArrayList.add(employee);
        notifyDataSetChanged();
       }

    @Override
    public int getItemCount() {
        return employeeArrayList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        TextView tvEmployeeName;
        TextView tvEmployeeBirth;
        TextView tvEmployeeWage;
        TextView tvEmployeeHire;
        ImageView imgEmployeeImage;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            tvEmployeeName = itemView.findViewById(R.id.tvEmployeeName);
            tvEmployeeBirth = itemView.findViewById(R.id.tvEmployeeBirth);
            tvEmployeeHire = itemView.findViewById(R.id.tvEmployeeHire);
            tvEmployeeWage = itemView.findViewById(R.id.tvEmployeeWage);
            imgEmployeeImage = itemView.findViewById(R.id.imgEmployeeImage);

        }
    }
}
