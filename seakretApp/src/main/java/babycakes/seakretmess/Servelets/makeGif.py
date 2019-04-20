import os
import imageio
import sys

png_dir = sys.argv[1] + '/'
images = []
file1 = open("test.txt","w")
file1.write(sys.argv[1])
file1.close() 
for file_name in os.listdir(png_dir):
    if file_name.startswith('redrawn'):
        file_path = os.path.join(png_dir, file_name)
        images.append(imageio.imread(file_path))
imageio.mimsave((png_dir + 'message.gif'), images, duration = 0.01666)