package ypp.SpringFlow.flowDome.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.apache.commons.lang3.text.WordUtils;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public enum  Topping implements Serializable {
        PEPPERONI,
        SAUSAGE,
        HAMBURGER,
        MUSHROOM,
        CANADIAN_BACON,
        PINEAPPLE,
        GREEN_PEPPER,
        JALAPENO,
        TOMATO,
        ONION,
        EXTRA_CHEESE;

        public static List<Topping> asList() {
            Topping[] all = Topping.values();
            return Arrays.asList(all);
        }

        @Override
        public String toString() {
            return WordUtils.capitalizeFully(name().replace('_', ' '));
        }
}
