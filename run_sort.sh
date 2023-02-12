# Print hardware details of the machine this script is running on
printf "Hardware Details:\n"
printf "\nOperating System, Type and Version\n"
cat /proc/version
printf "\nCPU Info\n"
grep -E 'processor|vendor_id|model name|processor|cpu MHz|cache size' /proc/cpuinfo
printf "\nMemory Info\n"
grep -E 'MemTotal' /proc/meminfo | numfmt --field 2 --from-unit=Ki --to=iec | sed 's/ kB//g'

java Sort $1
while read -r line; do
  echo $line
done
echo "."