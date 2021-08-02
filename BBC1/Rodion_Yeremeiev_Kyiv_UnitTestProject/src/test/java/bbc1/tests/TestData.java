package bbc1.tests;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class TestData {

    public static final Map<String, String> formDataIncorrectEmail = Stream.of(
        new String[][]{{"Name", "Bob"}, {"Email address", "invalidAddress"}, {"Contact number", "555-3258-11"},
                       {"Location", "Tokyo"}, {"Story", "some hard-coded character sequence"}}).collect(
        Collectors.toMap(p -> p[0], p -> p[1]));

    public static final Map<String, String> formDataNoStory = Stream.of(
        new String[][]{{"Name", "Bob"}, {"Email address", "adress@mail.com"}, {"Contact number", "555-3258-11"},
                       {"Location", "Tokyo"}, {"Story", ""}}).collect(Collectors.toMap(p -> p[0], p -> p[1]));

    public static final Map<String, String> formDataNoNameInput = Stream.of(
        new String[][]{{"Name", ""}, {"Email address", "adress@mail.com"}, {"Contact number", "555-3258-11"},
                       {"Location", "Tokyo"}, {"Story", "some hard-coded character sequence"}}).collect(Collectors.toMap(p -> p[0], p -> p[1]));

    public static final Map<String, String> formDataCorrectInput = Stream.of(
        new String[][]{{"Name", "Bob"}, {"Email address", "adress@mail.com"}, {"Contact number", "555-3258-11"},
                       {"Location", "Tokyo"}, {"Story", "some hard-coded character sequence"}}).collect(Collectors.toMap(p -> p[0], p -> p[1]));


}
