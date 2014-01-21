package com.mmswdev.mmkeyboard;

import android.graphics.Typeface;
import android.content.Context;

import java.util.Locale;

public class FontUtil {

    private static Typeface mZawgyiFont;
    private static Typeface mAnotherFont;
    private static LanguageSwitcher mLanguageSwitcher;

    public static enum FontType {

        ZAWGYI_FONT {
            public String toString() {
                return "fonts/ZawgyiOne.otf";
            }
        },

        ANOTHER_FONT {
            public String toString() {
                return "fonts/another.ttf";
            }
        }
    }

    public static void setLanguageSwitcher(LanguageSwitcher languageSwitcher) {
        mLanguageSwitcher = languageSwitcher;
    }

    /**
     * @return Typeface Instance with the font passed as parameter
     */
    public static Typeface getTypeface(Context context, Typeface defaultTypeface) {
        Typeface typeFace = null;

        Locale l = mLanguageSwitcher.getInputLocale();
        String lang = l.getLanguage();
        String country = l.getCountry();
        try {
            if (lang.equals("my") && (country.equals("ZG") || country.equals("ZB"))) {
                if (defaultTypeface == Typeface.DEFAULT ||
                    defaultTypeface == Typeface.DEFAULT_BOLD ||
                    defaultTypeface == Typeface.MONOSPACE ||
                    defaultTypeface == Typeface.SANS_SERIF ||
                    defaultTypeface == Typeface.SERIF) {
                    if (mZawgyiFont == null) {
                        mZawgyiFont = Typeface.createFromAsset(
                                context.getAssets(), FontType.ZAWGYI_FONT.toString());
                    }
                    typeFace = mZawgyiFont;
                } else {
                    if (mZawgyiFont == null) {
                        mZawgyiFont = Typeface.createFromAsset(
                                context.getAssets(), FontType.ZAWGYI_FONT.toString());
                    }
                    typeFace = mZawgyiFont;
                }
            } else if (lang.equals("my") && country.equals("UC")) {
                typeFace = defaultTypeface;
            } else {
                typeFace = defaultTypeface;
            }
        } catch (Exception ex) {
            android.util.Log.i("MMKeyboardDebug","default typeFace  exception = " + ex.toString());
            typeFace = defaultTypeface;
        }
        return typeFace;
    }

    public static Typeface getTypeface(Context context, String typefaceName) {
        Typeface typeFace = null;

        try {

            if (typefaceName.equals(FontType.ZAWGYI_FONT.toString())) {

                if (mZawgyiFont == null) {
                    mZawgyiFont = Typeface.createFromAsset(
                            context.getAssets(), typefaceName);
                }

                typeFace = mZawgyiFont;

            } else if (typefaceName.equals(FontType.ANOTHER_FONT.toString())) {

                if (mAnotherFont == null) {
                    mAnotherFont = Typeface.createFromAsset(
                            context.getAssets(), typefaceName);
                }

                typeFace = mAnotherFont;

            }

        } catch (Exception ex) {
            typeFace = Typeface.DEFAULT;
        }

        return typeFace;
    }

    /**
     * @return Typeface Instance with the font passed as parameter
     */
    public static Typeface getTypeface(Context context, FontType typefaceName) {
        return getTypeface(context, typefaceName.toString());
    }

    public static double getScale(Typeface defaultTypeface) {
        double scale = 1;
        Locale l = mLanguageSwitcher.getInputLocale();
        String lang = l.getLanguage();
        String country = l.getCountry();
        if (lang.equals("my") && (country.equals("ZG") || country.equals("ZB"))) {
            if (defaultTypeface == Typeface.DEFAULT ||
                    defaultTypeface == Typeface.DEFAULT_BOLD ||
                    defaultTypeface == Typeface.MONOSPACE ||
                    defaultTypeface == Typeface.SANS_SERIF ||
                    defaultTypeface == Typeface.SERIF) {
                        scale = 0.8;
            } else {
                scale = 0.8;
            }
        } else if (lang.equals("my") && country.equals("UC")) {
            scale = 1;
        } else {
            scale = 1;
        }
        return scale;
    }



}