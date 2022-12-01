package _2java8.lambda;

import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Collectors;


public class _1PredicateDemo {

    /**
     * Takes an argument and returns a boolean.
     *
     * Can be used to filter a list or check some conditions.
     * Predicates can be chained via and, or, negate etc
     */


    private static Predicate<Student> MALE_STUDENTS( ){
        return (x) -> (x.isMale());
    };

    private static Predicate<Student> HIGH_SCORE( int score ){
        return (x) -> (x.score() >= score);
    };


    //External Predicate
    private static final List<Student> getMaleStudents( List<Student> allStudents ){
        return allStudents.stream().filter(MALE_STUDENTS()).collect(Collectors.toList());
    }

    //Inlined Predicate
    private static final List<Student> geHighScoreStudents( List<Student> allStudents, int score ){
        return allStudents.stream().filter( x -> x.score() >= score ).collect(Collectors.toList());
    }

    //Chained Predicate
    private static final List<Student> getMaleHighScoreStudents( List<Student> allStudents, int score ){
        return allStudents.stream().filter( MALE_STUDENTS().and(HIGH_SCORE(score)) ).collect(Collectors.toList());
    }


    public static void main( String[] args ){
        List<Student> allStudents = List.of(
                new Student("Nick", true, 20),
                new Student("Vic", true, 90),
                new Student("Ramesh", true,70),
                new Student("Anne", false, 95),
                new Student("Tiff", false, 60)
        );

        System.out.println("Males: " + getMaleStudents( allStudents ));
        System.out.println("Students above 90: " + geHighScoreStudents( allStudents, 90 ));
        System.out.println("Males above 90: " + getMaleHighScoreStudents( allStudents, 90 ));

    }

}
