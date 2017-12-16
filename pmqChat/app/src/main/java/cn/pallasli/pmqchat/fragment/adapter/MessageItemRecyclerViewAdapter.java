package cn.pallasli.pmqchat.fragment.adapter;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import cn.pallasli.pmqchat.R;
import cn.pallasli.pmqchat.fragment.MessageItemFragment.OnListFragmentInteractionListener;
import cn.pallasli.pmqchat.fragment.dummy.MessageDummy;


import java.util.List;


public class MessageItemRecyclerViewAdapter extends RecyclerView.Adapter<MessageItemRecyclerViewAdapter.ViewHolder> {

    private final List<MessageDummy.DummyItem> mValues;
    private final OnListFragmentInteractionListener mListener;

    public MessageItemRecyclerViewAdapter(List<MessageDummy.DummyItem> items, OnListFragmentInteractionListener listener) {
        mValues = items;
        mListener = listener;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.fragment_messageitem, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(final ViewHolder holder, int position) {
        holder.mItem = mValues.get(position);
        holder.mIdView.setText(mValues.get(position).id);
        holder.mFriendCaption.setText(mValues.get(position).friendCaption);
        holder.mMessagetView.setText(mValues.get(position).friendCaption);

        holder.mView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (null != mListener) {
                    // Notify the active callbacks interface (the activity, if the
                    // fragment is attached to one) that an item has been selected.
                    mListener.onListFragmentInteraction(holder.mItem);
                }
            }
        });
    }

    @Override
    public int getItemCount() {
        return mValues.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        public final View mView;
        public final TextView mIdView;
        public final TextView mMessagetView;
        public final TextView mFriendCaption;
        public MessageDummy.DummyItem mItem;

        public ViewHolder(View view) {
            super(view);
            mView = view;
            mIdView = (TextView) view.findViewById(R.id.id);
            mMessagetView = (TextView) view.findViewById(R.id.message);
            mFriendCaption = (TextView) view.findViewById(R.id.friendCaption);
        }

        @Override
        public String toString() {
            return super.toString() + " '" + mMessagetView.getText() + "'";
        }
    }
}
