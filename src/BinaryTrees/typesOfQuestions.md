1. BalanceBT, MaximumPathSum, these question can be solved by normal recursion with repetitive calls. If you want to 
optimize it, toh parameterised recursion use kro and return vo kro jisse ans nikalega and ans ko paas kro argument mai
and har call pr ans update kro. Remember return ans nhi krna, ans nikaalne ke liye jo chaiye vo return krna hai
2. Like in BalancedBT usme true/false batana tha , but uske liye height of subtree of needed toh return height of subtree hi kri hai, and ans paas krne ki jaagah direct hi vaha pr calculate kr liye
3. MaximumPathSum mai max path sum batana tha, jo ki ans parameter mai update kr rhe hai, par use nikaalne ke liye left/right branch ka sum chaiye joki return kr rhe hai
4. Diameter of BT mai nikaalna diameter tha toh voh ans mai store kr rhe the , but use nikaalne ke liye height ki need thi jo ki return kr rhe the

### Pair jisme level store ho
1. If top view chaiye toh hume har horizontal level ki top node chaiye toh ek hashmap banao jisme har x level ki node ho 
and level order traverse kro and vaapis se x level ki node aaye toh update mt krna
2. If right side view chaiye toh hume har vertical level ki rightmost node chaiye, toh vese toh ma same uper vaale concept
se ho jaaega bas traversal right left krna padega level order traversal se ni hoga. But in real solution apan ne right left
traversal hi kiya hai but vertical level store krne ke liye koi class ni banai, since sabse pehli node y level ki rightmost hi hogi
toh us cheej ka use kra hai
3. If you want Vertical order traversal toh usme x,y dono level ki class banani padegi
