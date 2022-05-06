package REST.beans;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;


@XmlRootElement
@XmlAccessorType (XmlAccessType.FIELD)
public class Words {

    @XmlElement(name="my_words")
    private List<Word> wordlist;

    // To achieve singleton
    private static Words instance;

    private Words() {
        wordlist = new ArrayList<Word>();
    }

    //singleton
    public synchronized static Words getInstance(){
        if(instance==null)
            instance = new Words();
        return instance;
    }

    public synchronized List<Word> getWordlist() {

        return new ArrayList<>(wordlist);

    }

    public synchronized void setWordlist(List<Word> wordlist) {
        this.wordlist = wordlist;
    }

    public synchronized void add(Word u){
        wordlist.add(u);
    }

    public Word getByName(String name){
        List<Word> wordCopy = getWordlist();
        for(Word u: wordCopy)
            if(u.getName().toLowerCase().equals(name.toLowerCase()))
                return u;
        return null;
    }

    public synchronized boolean modify(Word word){
        List<Word> wordCopy = getWordlist();
        for (Word w: wordCopy){
            if(w.getName().toLowerCase().equals(word.getName().toLowerCase())){
                w.setDefinition(word.getDefinition());
                return true;
            }
        }

        return false;
    }
}
