package cn.pallasli.pmqchat.fragment.dummy;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class MessageDummy {
    public static final List<MessageDummy.DummyItem> ITEMS = new ArrayList<MessageDummy.DummyItem>();

    public static final Map<String, MessageDummy.DummyItem> ITEM_MAP = new HashMap<String, MessageDummy.DummyItem>();

    private static final int COUNT = 25;

    static {
        // Add some sample items.
        for (int i = 1; i <= COUNT; i++) {
            addItem(createDummyItem(i+1000));
        }
    }

    private static void addItem(MessageDummy.DummyItem item) {
        ITEMS.add(item);
        ITEM_MAP.put(item.id, item);
    }

    private static MessageDummy.DummyItem createDummyItem(int position) {
        return new MessageDummy.DummyItem(String.valueOf(position), "Item " + position, makeDetails(position));
    }

    private static String makeDetails(int position) {
        StringBuilder builder = new StringBuilder();
        builder.append("Details about Item: ").append(position);
//        for (int i = 0; i < position; i++) {
//            builder.append("\nMore details information here.");
//        }
        return builder.toString();
    }


    public static class DummyItem {
        public final String id;
        public final String friendCaption;
        public final String message;

        public DummyItem(String id, String friendCaption, String message) {
            this.id = id;
            this.friendCaption = friendCaption;
            this.message = message;
        }

        @Override
        public String toString() {
            return message;
        }
    }
}
