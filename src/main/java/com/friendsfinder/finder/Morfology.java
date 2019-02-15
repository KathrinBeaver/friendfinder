package com.friendsfinder.finder;

//import r
import jmorfsdk.JMorfSdk;
import jmorfsdk.load.JMorfSdkLoad;
import morphological.structures.internal.OmoForm;

import java.util.ArrayList;
import java.util.List;

public class Morfology {
        public Morfology()
        {
        }

        public static JMorfSdk SDK = JMorfSdkLoad.loadFullLibrary();;

        public static ArrayList<String> getForms(String word) throws Exception {
            ArrayList<String> array = new ArrayList<String>();

            List<OmoForm> characteristics = SDK.getAllCharacteristicsOfForm(word);
            characteristics.forEach((form) -> {

                if(!array.contains(form.getInitialFormString())) {
                    array.add(form.getInitialFormString());
                }
            });
            if(array.size()==0) array.add(word);
            return array;
        }

        public static void main(String[] args) throws Exception {

            ArrayList<String> array = getForms("маме");
        }
    }


