package pl.bottega.photostock.sales.application;

import pl.bottega.photostock.sales.model.Clip;
import pl.bottega.photostock.sales.model.Money;
import pl.bottega.photostock.sales.model.Picture;
import pl.bottega.photostock.sales.model.Product;

import java.util.HashSet;

/**
 * Created by Adam.Wronski on 2016-12-11.
 */
public class PictureEqualsTest {
    public static void main(String[] args) {
        Product picture1 = picture("123");
        Product picture2 = picture(null);
        Product picture3 = picture("123");
        Product picture4 = picture("066");

        Clip clip1 = clip("123");
        Clip clip2 = clip("256");
        Clip clip3 = clip("256");

        System.out.println("Positive");
        System.out.println(picture1.equals(picture3));
        System.out.println(picture3.equals(picture1));
        System.out.println(picture1.equals(picture1));
        System.out.println(picture2.equals(picture2));
        System.out.println(clip2.equals(clip3));

        System.out.println("Negative");
        System.out.println(picture1.equals(picture2));
        System.out.println(picture3.equals(picture4));
        System.out.println(picture2.equals(picture4));
        System.out.println(picture2.equals(null));
        System.out.println(picture1.equals(13));
        System.out.println(clip1.equals(clip2));



    }

    private static Clip clip(String number) {
        return new Clip(number, " ", 500l, Money.valueOf(1));

    }

    private static Product picture(String number) {
        return new Picture(number,"", new HashSet<>(), Money.valueOf(100));
    }
}
