"""15 Functions"""

def string_times(str, n):
  return str*n
def front_times(str, n):
  return str[0:3]*n
def string_bits(str):
  return str[0:900:2]
def string_splosion(str):
  c = ""
  for x in range(len(str)):
    c = c + str[:x+1]
  return c
def last2(str):
  m=len(str)
  if m < 2:
    return 0
  
  last2 = str[m-2:]
  num = 0
  for x in range(m-2):
    s = str[x:x+2]
    if s == last2:
      num = num + 1
  return num
def array_count9(nums):
  c=0
  for nums in nums:
    if nums ==9:
      c=c+1
  return c
def array_front9(nums):

  m = len(nums)
  if m > 4:
    m = 4
  
  for x in range(m): 
    if nums[x] == 9:
      return True
  return False
def array123(nums):
  for i in range(len(nums)-2):
    if nums[i]==1 and nums[i+1]==2 and nums[i+2]==3:
      return True
  return False
def string_match(a, b):

  shorter = min(len(a), len(b))
  count = 0
  
  for i in range(shorter-1):
    a_sub = a[i:i+2]
    b_sub = b[i:i+2]
    if a_sub == b_sub:
      count = count + 1

  return count
def double_char(str):
    outstr = ''
    for character in str:
        outstr = outstr + character + character
    return outstr
def count_hi(l):
  count =0
  for i in range(len(l)-1):
    if l[i]+l[i+1] =='hi':
      count =count + 1
  return count
def cat_dog(str):
  dcount=0
  ccount=0
  for i in range(len(str)-2):
    if str[i]+str[i+1]+str[i+2]=='cat':
      ccount=ccount+1
    if str[i]+str[i+1]+str[i+2]=='dog': 
      dcount=dcount+1
  if dcount==ccount:
    return True
  else: return False
def count_code(str):
  ccount=0
  for i in range(len(str)-3):
    if str[i]=='c' and str[i+1]=='o'and str[i+3]=='e':
      ccount=ccount+1
  return ccount
def xyz_there(str):
    if str[0:3]=='xyz':
      return True
    for i in range(1, len(str)-2):
      if str[i-1:i+3]=='.xyz':
        continue
      elif str[i:i+3]=='xyz':
        return True
    return False
def count_evens(nums):
  count=0
  for i in range(len(nums)):
    if nums[i]%2==0:
      count=count+1
  return count
