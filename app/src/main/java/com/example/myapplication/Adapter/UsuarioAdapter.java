package com.example.myapplication.Adapter;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.example.myapplication.MainActivity2;
import com.example.myapplication.Model.Usuario1;
import com.example.myapplication.Model.Usuario2;
import com.example.myapplication.R;

import java.io.Serializable;
import java.util.List;


public class UsuarioAdapter extends RecyclerView.Adapter<UsuarioAdapter.UsuarioViewHolder> {

    private Context Ctx;
    private List<Usuario1> lstUsuarios;
    private List<Usuario2> lstUsuarios2;

    public UsuarioAdapter(Context mCtx, List<Usuario1> usuarios) {
        this.lstUsuarios = usuarios;
        Ctx=mCtx;
    }

    @Override
    public UsuarioViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        //inflating and returning our view holder
        LayoutInflater inflater = LayoutInflater.from(Ctx);
        View view = inflater.inflate(R.layout.item_usuario, null);
        return new UsuarioViewHolder(view);
    }

    @Override
    public void onBindViewHolder(UsuarioViewHolder holder, int position) {

        Usuario1 usuario = lstUsuarios.get(position);
        holder.textViewName.setText(usuario.getNombre());
        holder.textViewArea.setText(usuario.getArea());
        holder.textViewURLFoto.setText(usuario.getUrlfoto());
        Glide.with(Ctx)
                .load(usuario.getFoto())
                .error(R.drawable.unknown)
                .into(holder.imageView);
        //Segundo activity
        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(holder.itemView.getContext(), MainActivity2.class);
                intent.putExtra("itemDetail", (Serializable) lstUsuarios2);
                holder.itemView.getContext().startActivity(intent);
            }
        });
    }


    @Override
    public int getItemCount() {
        return lstUsuarios.size();
    }


    class UsuarioViewHolder extends RecyclerView.ViewHolder {

        TextView textViewName, textViewURLFoto, textViewArea;
        ImageView imageView;

        public UsuarioViewHolder(View itemView) {
            super(itemView);

            textViewName= itemView.findViewById(R.id.txtName);
            textViewURLFoto = itemView.findViewById(R.id.txtUrlFoto);
            textViewArea = itemView.findViewById(R.id.txtArea);
            imageView = itemView.findViewById(R.id.imgFoto);
        }
    }


}
