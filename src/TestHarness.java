import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

import org.junit.Assert;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

class TestHarness {
   static final String[] UNIVERSE = new String[]{"Apple", "Banana", "Cherry", "Date", "Elderberry", "Fig", "Grape", "Honeydew", "Kiwi", "Lemon"};
   private static boolean[] emptySet;
   private static boolean[] fullSet;
   private static boolean[] sampleA;
   private static boolean[] sampleB;
   private static boolean[] disjointA;
   private static boolean[] disjointB;
   private static boolean[] alternatingA;
   private static boolean[] alternatingB;
   private static boolean[] singleA;
   private static boolean[] singleB;
   private static int[] emptyBag;
   private static int[] allSevensBag;
   private static int[] sampleBagA;
   private static int[] sampleBagB;
   private static int[] varyingBagA;
   private static int[] varyingBagB;
   private static int[] boundaryBagA;
   private static int[] boundaryBagB;
   private static int[] alternatingBagA;
   private static int[] alternatingBagB;

   @BeforeAll
   public static void setUpOnce() {
	// Get the current date
	    LocalDate today = LocalDate.now();
	    
	   
	    String formattedDate = today.format(DateTimeFormatter.ISO_LOCAL_DATE);
	   
      System.out.println("==========================================");
      System.out.println("CSIS2430 Project 1 - JUnit Test Suite");
      System.out.println("==========================================");
      System.out.println("Team: TBD");
      System.out.println("Members: Naomi, Alejandro, Bryant, Han");
      System.out.println("Verification Lead: Alejandro Pasillas");
      
      System.out.println("Test Date: " + formattedDate);
      initializeTestData();
   }

   private static void initializeTestData() {
      emptySet = new boolean[10];
      fullSet = new boolean[10];

      int i;
      for(i = 0; i < 10; ++i) {
         fullSet[i] = true;
      }

      sampleA = new boolean[]{true, false, true, false, true, false, true, false, false, true};
      sampleB = new boolean[]{false, true, true, false, false, true, false, true, false, false};
      disjointA = new boolean[]{true, true, false, false, false, false, false, false, false, false};
      disjointB = new boolean[]{false, false, true, true, false, false, false, false, false, false};
      alternatingA = new boolean[]{true, false, true, false, true, false, true, false, true, false};
      alternatingB = new boolean[]{false, true, false, true, false, true, false, true, false, true};
      singleA = new boolean[]{true, false, false, false, false, false, false, false, false, false};
      singleB = new boolean[]{false, true, false, false, false, false, false, false, false, false};
      emptyBag = new int[10];
      allSevensBag = new int[10];

      for(i = 0; i < 10; ++i) {
         allSevensBag[i] = 7;
      }

      sampleBagA = new int[]{2, 0, 1, 0, 3, 0, 1, 0, 0, 2};
      sampleBagB = new int[]{1, 1, 0, 2, 1, 0, 0, 3, 0, 1};
      varyingBagA = new int[]{3, 3, 3, 0, 0, 0, 0, 0, 0, 0};
      varyingBagB = new int[]{1, 2, 5, 0, 0, 0, 0, 0, 0, 0};
      boundaryBagA = new int[]{0, 1, 10, 100, 1000, Integer.MAX_VALUE, 0, 0, 0, 0};
      boundaryBagB = new int[]{5, 5, 5, 5, 5, 5, 5, 5, 5, 5};
      alternatingBagA = new int[]{5, 0, 5, 0, 5, 0, 5, 0, 5, 0};
      alternatingBagB = new int[]{0, 3, 0, 3, 0, 3, 0, 3, 0, 3};
   }

   @Test
   public void testTC1_Union() {
      boolean[] expected = new boolean[]{true, true, true, false, true, true, true, true, false, true};
      Assert.assertArrayEquals("TC1: A ∪ B failed", expected, Main.union(sampleA, sampleB));
   }

   @Test
   public void testTC1_Intersection() {
      boolean[] expected = new boolean[]{false, false, true, false, false, false, false, false, false, false};
      Assert.assertArrayEquals("TC1: A ∩ B failed", expected, Main.intersection(sampleA, sampleB));
   }

   @Test
   public void testTC1_Difference() {
      boolean[] expected = new boolean[]{true, false, false, false, true, false, true, false, false, true};
      Assert.assertArrayEquals("TC1: A - B failed", expected, Main.difference(sampleA, sampleB));
   }

   @Test
   public void testTC1_Complement() {
      boolean[] expected = new boolean[]{false, true, false, true, false, true, false, true, true, false};
      Assert.assertArrayEquals("TC1: NOT(A) failed", expected, Main.complement(sampleA));
   }

   @Test
   public void testTC1_SymmetricDifference() {
      boolean[] expected = new boolean[]{true, true, false, false, true, true, true, true, false, true};
      Assert.assertArrayEquals("TC1: A ⊕ B failed", expected, Main.symmetricDifference(sampleA, sampleB));
   }

   @Test
   public void testTC1_MultiUnion() {
      int[] expected = new int[]{2, 1, 1, 2, 3, 0, 1, 3, 0, 2};
      Assert.assertArrayEquals("TC1: Bag ∪ failed", expected, Main.multisetUnion(sampleBagA, sampleBagB));
   }

   @Test
   public void testTC1_MultiIntersection() {
      int[] expected = new int[]{1, 0, 0, 0, 1, 0, 0, 0, 0, 1};
      Assert.assertArrayEquals("TC1: Bag ∩ failed", expected, Main.multisetIntersection(sampleBagA, sampleBagB));
   }

   @Test
   public void testTC1_MultiDifference() {
      int[] expected = new int[]{1, 0, 1, 0, 2, 0, 1, 0, 0, 1};
      Assert.assertArrayEquals("TC1: Bag - failed", expected, Main.multisetDifference(sampleBagA, sampleBagB));
   }

   @Test
   public void testTC1_MultiSum() {
      int[] expected = new int[]{3, 1, 1, 2, 4, 0, 1, 3, 0, 3};
      Assert.assertArrayEquals("TC1: Bag + failed", expected, Main.multisetSum(sampleBagA, sampleBagB));
   }

   @Test
   public void testTC2_EmptySet_Union() {
      Assert.assertArrayEquals("TC2: Empty ∪ B = B", sampleB, Main.union(emptySet, sampleB));
   }

   @Test
   public void testTC2_EmptySet_Intersection() {
      Assert.assertArrayEquals("TC2: Empty ∩ B = empty", emptySet, Main.intersection(emptySet, sampleB));
   }

   @Test
   public void testTC2_EmptySet_Difference() {
      Assert.assertArrayEquals("TC2: Empty - B = empty", emptySet, Main.difference(emptySet, sampleB));
   }

   @Test
   public void testTC2_EmptySet_Complement() {
      Assert.assertArrayEquals("TC2: NOT(empty) = full", fullSet, Main.complement(emptySet));
   }

   @Test
   public void testTC2_EmptySet_SymmetricDifference() {
      Assert.assertArrayEquals("TC2: Empty ⊕ B = B", sampleB, Main.symmetricDifference(emptySet, sampleB));
   }

   @Test
   public void testTC2_EmptyBag_Union() {
      Assert.assertArrayEquals("TC2: Empty bag ∪ B = B", sampleBagB, Main.multisetUnion(emptyBag, sampleBagB));
   }

   @Test
   public void testTC2_EmptyBag_Intersection() {
      Assert.assertArrayEquals("TC2: Empty bag ∩ B = empty", emptyBag, Main.multisetIntersection(emptyBag, sampleBagB));
   }

   @Test
   public void testTC2_EmptyBag_Difference() {
      Assert.assertArrayEquals("TC2: Empty bag - B = empty", emptyBag, Main.multisetDifference(emptyBag, sampleBagB));
   }

   @Test
   public void testTC2_EmptyBag_Sum() {
      Assert.assertArrayEquals("TC2: Empty bag + B = B", sampleBagB, Main.multisetSum(emptyBag, sampleBagB));
   }

   @Test
   public void testTC3_FullSet_Union() {
      Assert.assertArrayEquals("TC3: Full ∪ B = full", fullSet, Main.union(fullSet, sampleB));
   }

   @Test
   public void testTC3_FullSet_Intersection() {
      Assert.assertArrayEquals("TC3: Full ∩ B = B", sampleB, Main.intersection(fullSet, sampleB));
   }

   @Test
   public void testTC3_FullSet_Difference() {
      boolean[] expected = new boolean[]{true, false, false, true, true, false, true, false, true, true};
      Assert.assertArrayEquals("TC3: Full - B", expected, Main.difference(fullSet, sampleB));
   }

   @Test
   public void testTC3_FullSet_Complement() {
      Assert.assertArrayEquals("TC3: NOT(full) = empty", emptySet, Main.complement(fullSet));
   }

   @Test
   public void testTC3_AllSevens_Union() {
      int[] expected = new int[]{7, 7, 7, 7, 7, 7, 7, 7, 7, 7};
      Assert.assertArrayEquals("TC3: 7s ∪ B = 7s", expected, Main.multisetUnion(allSevensBag, sampleBagB));
   }

   @Test
   public void testTC3_AllSevens_Intersection() {
      Assert.assertArrayEquals("TC3: 7s ∩ B = B", sampleBagB, Main.multisetIntersection(allSevensBag, sampleBagB));
   }

   @Test
   public void testTC3_AllSevens_Difference() {
      int[] expected = new int[]{6, 6, 7, 5, 6, 7, 7, 4, 7, 6};
      Assert.assertArrayEquals("TC3: 7s - B", expected, Main.multisetDifference(allSevensBag, sampleBagB));
   }

   @Test
   public void testTC3_AllSevens_Sum() {
      int[] expected = new int[]{8, 8, 7, 9, 8, 7, 7, 10, 7, 8};
      Assert.assertArrayEquals("TC3: 7s + B", expected, Main.multisetSum(allSevensBag, sampleBagB));
   }
}
