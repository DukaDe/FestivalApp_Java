package festivalaplikacija.klijent.validacija;

import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 *
 * @author Dušan Kalejski dramski pedagog
 */
public class Validacija{

    private static Validacija instance;
    private Pattern pattern;
    private Matcher matcher;

    private Validacija() {
    }

    public static Validacija getInstance() {
        if (instance == null) {
            instance = new Validacija();
        }
        return instance;
    }


    public boolean isEmail(String email) throws Exception {
        if (email.isEmpty() || email.isBlank()) {
            throw new Exception("Sva polja moraju biti popunjena!");
        }
        pattern = Pattern.compile("^(.+)@(.+)[.](.+)$");
        matcher = pattern.matcher(email);
        if (matcher.find() == false) {
            throw new Exception("Nepravilan unos email adrese");
        }
        return true;
    }

    public boolean isEmpty(String unos) throws Exception {
        if (unos.isEmpty() || unos.isBlank()) {
            throw new Exception("Sva polja moraju biti popunjena!");
        }
        return true;
    }


    public boolean isString(String unos) throws Exception {
        if (unos.isEmpty() || unos.isBlank()) {
            throw new Exception("Sva polja moraju biti popunjena!");
        }
        pattern = Pattern.compile("\\d");
        matcher = pattern.matcher(unos);
        if (matcher.find()) {
            throw new Exception("U polje osoba/naziv ne smeju biti uneti brojevi");
        }
        return true;
    }


    public boolean isNumber(String brojTelefona) throws Exception {
        if (brojTelefona.isEmpty() || brojTelefona.isBlank()) {
            throw new Exception("Sva polja moraju biti popunjena!");
        }
        pattern = Pattern.compile("\\d");
        matcher = pattern.matcher(brojTelefona);
        if (matcher.find() == false) {
            throw new Exception("U polje mogu biti uneti samo brojevi");
        }
        try{
            int broj = Integer.parseInt(brojTelefona);
            return true;
        }catch(Exception e){
            throw new Exception("U polje telefonski broj mogu biti uneti samo brojevi");
        }

    }


    public boolean isObject(Object object, List<Object> objects) throws Exception {
        if (objects == null) {
            throw new Exception("Doslo je do problema prilikom dodavanja entiteta u bazu");
        }
        for (Object o : objects) {
            if (o.equals(object)) {
                throw new Exception("Ovakav entitet vec postoji u bazi");
            }
        }
        return true;
    }
    
   
}
