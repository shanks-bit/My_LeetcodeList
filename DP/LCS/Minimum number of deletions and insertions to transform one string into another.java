// gfg -> https://www.geeksforgeeks.org/dsa/minimum-number-deletions-insertions-transform-one-string-another/

/* find lcs
  then no. of deletion would be = a.length - lcs
  and no. of insertion would be = b.length - lcs

  a = "heap", b = "pea" 
  lcs = "ea"
  so deletion would be => "heap" -> "ea" (h, p deleted)
  and insertion would be => "pea" -> "ea" (p inserted)

  */
