package com.gmail.gabrielkorherr;

import java.util.*;

public class Main {
    public static void main(String[] args) {
        var dot = "dot 6  9";
        var line = "line 3 5 8 13";
        var error = "dot 4 2 0";

        operation(dot).ifPresentOrElse(Runnable::run, () -> System.out.println("Error parsing dot"));
        operation(line).ifPresentOrElse(Runnable::run, () -> System.out.println("Error parsing line"));
        operation(error).ifPresentOrElse(Runnable::run, () -> System.out.println("Caught error successfully"));
    }

    private static Optional<Runnable> operation(String source) {
        assert source != null : "source must not be null";

        final var split = List.of(source.split(" +"));
        return split.isEmpty() ? Optional.empty() : namedOperation(split.getFirst(), split.subList(1, split.size()));
    }

    private static Optional<Runnable> namedOperation(String name, List<String> args) {
        assert name != null : "name must not be null";
        assert args != null : "args must not be null";

        return switch (name) {
            case "dot" -> dotOperation(args);
            case "line" -> lineOperation(args);
            default -> Optional.empty();
        };
    }

    private static Optional<Runnable> dotOperation(List<String> args) {
        assert args != null : "args must not be null";

        return args.size() == 2 ? dotOperation(args.getFirst(), args.getLast()) : Optional.empty();
    }

    private static Optional<Runnable> dotOperation(String sourceX, String sourceY) {
        assert sourceX != null : "sourceX must not be null";
        assert sourceY != null : "sourceY must not be null";

        return parseInt(sourceX).flatMap(x ->
                parseInt(sourceY).map(y ->
                        dotOperation(x, y)));
    }

    private static Runnable dotOperation(int x, int y) {
        return () -> System.out.println("dot (" + x + ", " + y + ')');
    }

    private static Optional<Runnable> lineOperation(List<String> args) {
        assert args != null : "args must not be null";

        return lineParameters(args).map(Main::lineOperation);
    }

    private static Runnable lineOperation(LineParameters parameters) {
        return () -> System.out.println("line (" + parameters.startX + ", " + parameters.startY + ")" +
                " -> (" + parameters.endX + ", " + parameters.endY + ")");
    }

    private record LineParameters(int startX, int startY, int endX, int endY) {
    }

    private static Optional<LineParameters> lineParameters(List<String> args) {
        assert args != null : "args must not be null";

        return args.size() == 4 ?
                parseInt(args.get(0)).flatMap(startX ->
                        parseInt(args.get(1)).flatMap(startY ->
                                parseInt(args.get(2)).flatMap(endX ->
                                        parseInt(args.get(3)).map(endY ->
                                                new LineParameters(startX, startY, endX, endY))
                                )
                        )
                ) : Optional.empty();
    }

    private static Optional<Integer> parseInt(String source) {
        assert source != null : "source must not be null";

        try {
            return Optional.of(Integer.parseInt(source));
        } catch (NumberFormatException e) {
            return Optional.empty();
        }
    }
}