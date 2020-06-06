import sys
#print(f"{sys.argv}")
length = len(sys.argv)

if length!=3:
    print("invalid input args... exiting script.")
    sys.exit()

user_str = sys.argv[1]
user_action = sys.argv[2]

if(user_action=="lower"):
    print(user_str.lower())
elif(user_action=="upper"):
    print(user_str.upper())
elif(user_action=="title"):
    print(user_str.title())
elif(user_action=="reverse"):
    reverse = user_str[::-1]
    print(reverse)
else:
    print(f"{user_str}")
