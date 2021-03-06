package com.dia.mous.lecteurdenews;

import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import org.w3c.dom.Document;
import org.w3c.dom.Element;

public class MonAdapter extends RecyclerView.Adapter<MonAdapter.MonViewHolder> implements XMLAsyncTask.DocumentConsumer {

    private Document _document = null;
    public static String monUrl = "monHtmlContent";

    @Override
    public int getItemCount() {
        if(_document != null){
            return _document.getElementsByTagName("item").getLength();
        }
        else {
            return 0;
        }
    }

    @Override
    public MonViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        View view = inflater.inflate(R.layout.list_cell, parent, false);
        return new MonViewHolder(view);
    }

    @Override
    public void onBindViewHolder(MonViewHolder holder, int position) {
        Element item = (Element) _document.getElementsByTagName("item").item(position);
        holder.setElement(item);
    }

    @Override
    public void setXMLDocument(Document document)
    {
        _document = document;
        notifyDataSetChanged();
    }

    public class MonViewHolder extends RecyclerView.ViewHolder {

        private final TextView _titre;
        private Element _currentElement;
        private String _link;

        public MonViewHolder(final View itemView) {
            super(itemView);

            _titre = ((TextView)itemView.findViewById(R.id.titre));

            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                Context context = view.getContext();
                Intent i = new Intent(view.getContext(), WebViewActivity.class);
                _link = _currentElement.getElementsByTagName("link").item(0).getTextContent();
                i.putExtra(monUrl, _link);
                context.startActivity(i);
                }
            });
        }

        public void setElement(Element element)
        {
            _currentElement = element;
            _titre.setText(element.getElementsByTagName("title").item(0).getTextContent());
        }
    }


}
