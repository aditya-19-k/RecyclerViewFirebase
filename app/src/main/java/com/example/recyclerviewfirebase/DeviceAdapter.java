package com.example.recyclerviewfirebase;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.firebase.ui.database.FirebaseRecyclerAdapter;
import com.firebase.ui.database.FirebaseRecyclerOptions;

import de.hdodenhof.circleimageview.CircleImageView;

public class DeviceAdapter extends FirebaseRecyclerAdapter<DeviceModel,DeviceAdapter.DeviceViewHolder> {

    /**
     * Initialize a {@link RecyclerView.Adapter} that listens to a Firebase query. See
     * {@link FirebaseRecyclerOptions} for configuration options.
     *
     * @param options
     */
    public DeviceAdapter(@NonNull FirebaseRecyclerOptions<DeviceModel> options) {
        super(options);

    }

    @Override
    protected void onBindViewHolder(@NonNull DeviceAdapter.DeviceViewHolder holder, int position, @NonNull DeviceModel model) {

        holder.deviceName.setText(model.getDeviceName());
        holder.deviceNum.setText(model.getDeviceNum());
        holder.tvLatitude.setText(model.getLatitude());
        holder.vtLongitude.setText(model.getLongitude());

        Glide.with(holder.deviceImage.getContext())
                .load(model.getDeviceImage())
                .placeholder(R.drawable.ic_launcher_background)
                .circleCrop()
                .error(com.firebase.ui.database.R.drawable.common_google_signin_btn_icon_dark_normal)
                .into(holder.deviceImage);

    }

    @NonNull
    @Override
    public DeviceAdapter.DeviceViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.device_item,parent,false);
        return new DeviceViewHolder(view);
    }

    public class DeviceViewHolder extends RecyclerView.ViewHolder {
        CircleImageView deviceImage;
        TextView deviceName,deviceNum,tvLatitude,vtLongitude;

        public DeviceViewHolder(@NonNull View itemView) {
            super(itemView);

            deviceImage = itemView.findViewById(R.id.recDevImage);
            deviceName = itemView.findViewById(R.id.recDevName);
            deviceNum = itemView.findViewById(R.id.recDevNum);
            tvLatitude = itemView.findViewById(R.id.tvLatitude);
            vtLongitude = itemView.findViewById(R.id.tvLongitude);
        }
    }
}
