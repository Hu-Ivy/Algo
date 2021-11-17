package exercise;

public class Trie {
    private final Trie[] childen;
    private boolean isEnd;

    public Trie() {
        childen = new Trie[26];
        isEnd = false;
    }
    public void insert(String word) {
        Trie node = this;
        for (int i = 0; i < word.length(); i++) {

            char ch = word.charAt(i);
            int index = ch-'a';

            if (node.childen[index]==null) {
                node.childen[index] = new Trie();
            }
            node = node.childen[index];
        }
        node.isEnd = true;
    }

    public int insertR(String word) {
        Trie node = this;
        boolean isNew = false;
        for (int i = word.length()-1; i >=0; i--) {

            char ch = word.charAt(i);
            int index = ch-'a';

            if (node.childen[index]==null) {
                isNew=true;
                node.childen[index] = new Trie();
            }
            node = node.childen[index];
        }
        return isNew?word.length()+1:0;
    }
    public boolean search(String word) {
        Trie t = searchPrefix(word);
        return t!=null&&t.isEnd;
    }
    public boolean startsWith(String prefix) {
        return searchPrefix(prefix)!=null;
    }
    private Trie searchPrefix(String prefix) {
        Trie node = this;

        for (int i = 0; i < prefix.length(); i++) {
            char ch = prefix.charAt(i);
            int index = ch-'a';

            if (node.childen[index]==null) {
                return null;
            }
            node = node.childen[index];
        }
        return node;
    }
}
