import os
import imageio
import sys

png_dir = sys.argv[1] + '/'
images = []

for file_name in os.listdir(png_dir):
    if file_name.startswith('redrawn'):
        file_path = os.path.join(png_dir, file_name)
        images.append(imageio.imread(file_path))
try:
	imageio.mimsave((png_dir + 'message.gif'), images, duration = 0.01666)
except:
	file = open("test.txt", "w")
	file.write(png_dir)
	file.close()