package com.elsafeir.mbsoft.apiapp.Adapter;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.elsafeir.mbsoft.apiapp.Model.ResponseModel;
import com.elsafeir.mbsoft.apiapp.R;

import java.util.ArrayList;

public class PostAdapter extends RecyclerView.Adapter<PostAdapter.PostHolder>{

    ArrayList<ResponseModel> responseModels;

    public PostAdapter(ArrayList<ResponseModel> responseModels) {
        this.responseModels = responseModels;
    }

    @NonNull
    @Override
    public PostHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.post_item, viewGroup, false);
        PostHolder holder = new PostHolder(view);
        return holder;
    }

    @Override
    public void onBindViewHolder(@NonNull PostHolder viewHolder, int i) {
        ResponseModel responseModel = responseModels.get(i);
        viewHolder.userId.setText(responseModel.getUserId()+"");
        viewHolder.id.setText(responseModel.getId()+"");
        viewHolder.title.setText(responseModel.getTitle());
        viewHolder.body.setText(responseModel.getBody());

    }

    @Override
    public int getItemCount() {
        return responseModels.size();
    }

    class PostHolder extends RecyclerView.ViewHolder{
        TextView userId, id, title, body;

        public PostHolder(@NonNull View itemView) {
            super(itemView);
            userId = itemView.findViewById(R.id.userId);
            id = itemView.findViewById(R.id.id);
            title = itemView.findViewById(R.id.title);
            body = itemView.findViewById(R.id.body);

        }
    }
}
