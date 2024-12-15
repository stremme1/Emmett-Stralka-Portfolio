import json

# Load JSON data from files
with open('following.json', 'r') as f:
    following_data = json.load(f)

with open('followers_1.json', 'r') as f:
    followers_data = json.load(f)

# Extract the list of usernames from the following data
following = set()
for user in following_data['relationships_following']:
    for user_detail in user['string_list_data']:
        following.add(user_detail['value'])

# Extract the list of usernames from the followers data
followers = set()
for user in followers_data['relationships_followers']:
    for user_detail in user['string_list_data']:
        followers.add(user_detail['value'])

# Determine who is not following back
not_following_back = following - followers

# Output the result
print("Users who are not following back:")
for user in not_following_back:
    print(user)
