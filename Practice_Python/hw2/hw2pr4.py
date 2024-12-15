#Python bat 
#Did 50 
def sleep_in(weekday, vacation):
  if not weekday or vacation:
    return True
  else:
    return False
''
def monkey_trouble(a_smile, b_smile):
  if a_smile and b_smile:
    return True
  elif not a_smile and not b_smile:
    return True
  else:
    return False
''
def sum_double(a, b):
  if a==b:
    return 2*(a+b)
  return a+b
''
def diff21(n):
  if n>21:
    return 2*(n-21)
  return 21-n
''
def parrot_trouble(talking, hour):
  return (talking and (hour < 7 or hour > 20))
''
def makes10(a, b):
  if a == 10 or b==10 or a+b==10:
    return True
  return False
''
def near_hundred(n):
  if abs(100-n) <=10 or abs(200-n) <=10:
    return True
  return False
''
def pos_neg(a, b, negative):
  if negative:
    return (a < 0 and b < 0)
  else:
    return ((a < 0 and b > 0) or (a > 0 and b < 0))
''
def not_string(str):
  if str[0:3] == 'not':
    return str
  else:
    return 'not ' +str
''
def missing_char(str, n):
  kit = str[n+1:] 
  kat = str[:n]   
  return kat + kit
''
def front_back(str):
  m= len(str)
  if m <= 1:
    return str
  
  f = str[1:m-1:] 
  e = str[m-1]   
  return e + f + str[0]
''
def front3(str):
  return str[0:3]*3
'Warmup 2'
def string_times(str, n):
  return str*n
''
def front_times(str, n):
  return str[0:3]*n
''
def string_bits(str):
  return str[0:900:2]
''
def string_splosion(str):
  c = ""
  for x in range(len(str)):
    c = c + str[:x+1]
  return c
""
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
""
def array_count9(nums):
  c=0
  for nums in nums:
    if nums ==9:
      c=c+1
  return c
""
def array_front9(nums):

  m = len(nums)
  if m > 4:
    m = 4
  
  for x in range(m): 
    if nums[x] == 9:
      return True
  return False
'String 1'
def hello_name(name):
  return 'Hello ' + name + '!'
''
def make_abba(a, b):
  return a + 2*b +a
''
def make_tags(tag, word):
  return '<'+tag+'>' + word + '</'+tag+'>'
''
def make_out_word(out, word):
  return out[0:2] + word + out[2:9]
""
def extra_end(str):
  return 3*(str[-2:])
''"
def first_two(str):
  return str[0:2]
''
def first_half(str):
  m= len(str)/2
  return str[0:m]
''
def without_end(str):
  m= len(str)
  return str[1:m-1]
''
def combo_string(a, b):
  if len(a) > len(b):
    return b +a +b
  return a+b+a
''
def non_start(a, b):
  f=a[1:]
  s=b[1:]
  return f +s
''
def left2(str):
  f=str[0:2]
  s=str[2:]
  return s +f
'List 1'
def first_last6(nums):
  if nums[0]==6 or nums[-1]==6:
    return True
  return False
''
def same_first_last(nums):
  if len(nums) >=1 and nums[0]==nums[-1]:
    return True
  return False
""
def make_pi():
  return [3,1,4]
''
def common_end(a, b):
  if a[0]==b[0] or a[-1] ==b[-1]:
    return True
  return False
''
def sum3(nums):
  return sum(nums)
''
def rotate_left3(nums):
  return [nums[1],nums[2] ,nums[0]]
''
def reverse3(nums):
  return [nums[2],nums[1] ,nums[0]]
''
def max_end3(nums):
  return [nums[0]] * 3 if nums[0] >= nums[-1] else [nums[-1]] * 3
''
def sum2(nums):
  if len(nums)>2 or len(nums)==2:
    return nums[0]+nums[1]
  elif len(nums) ==1:
    return nums[0]
  return 0
''
def middle_way(a, b):
  return [a[1] ,b[1]]
''
def make_ends(nums):
  return [nums[0] ,nums[-1]]
''
def has23(nums):
  if nums[0]==2 or nums[1] ==2 or nums[0] ==3 or nums[1] ==3:
    return True
  return False
'Logic 1'
def cigar_party(cigars, is_weekend):
  return cigars >= 40 and cigars <= 60 or is_weekend
''
def date_fashion(you, date):
  if you<=2 or date <=2:
    return 0
  if you>=8 or date >=8:
    return 2
  return 1
""
def squirrel_play(temp, is_summer):
  if is_summer and temp <=100 and temp>=90:
    return True
  if temp<=90 and temp>=60:
    return True
  return False
''
def caught_speeding(speed, is_birthday):
    s = speed-5*is_birthday
    return (s>60)+(s>80)
""
def sorta_sum(a, b):
  if a+b >= 10 and a+b <= 19:
    return 20
  return a+b
''
def alarm_clock(day, vacation):
  if not vacation:
    if 1 <= day <= 5:
      return '7:00'
    return '10:00'
  
  if 1 <= day <= 5:
    return '10:00'
  return 'off'
''
def love6(a, b):
  if a==6 or b==6 or a+b==6 or b-a==6 or a-b==6: 
    return True
  return False
''
def in1to10(n, outside_mode):
  if outside_mode:
    return True
  if n in range(1,11):
    return True
  return False
""
def near_ten(num):
  if num % 10 in [0,1,2,8,9,10]:
    return True 
  return False


