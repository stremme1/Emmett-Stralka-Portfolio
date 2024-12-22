from PIL import Image

# Load image
img = Image.open("/Users/emmettstralka/Desktop/Images/TEST.png")

# Convert image to black and white
img = img.convert('L')

# Get image size
width, height = img.size

# Create empty matrix
matrix = []

# Iterate over image pixels and convert to 0, 1 or '_' based on brightness
for y in range(height):
    row = []
    for x in range(width):
        pixel = img.getpixel((x, y))
        if pixel < 85:
            row.append('1')
        elif pixel < 170:
            row.append('_')
        else:
            row.append('0')
    matrix.append(row)

# Print matrix
print("Matrix:")
for row in matrix:
    print("".join("{:<2}".format(elem) for elem in row))