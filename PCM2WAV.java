package com.cpic.recording.web.rest.util;

/**
 * Created by pc-1 on 2019/6/11.
 */

//import ua.mobius.media.server.impl.dsp.audio.g729.*;

/**
 * PCM文件转换成Wav格式音频
 * @author chuanye.wan
 *
 */
public class PCM2WAV {


    /**
     * 转换音频文件
     * @param src 需要转换的pcm音频路径
     * @param target 保存转换后wav格式的音频路径
     * @throws Exception
     */
//    public static void convertAudioFiles(String src, String target) throws IOException {
//        FileInputStream fis = null;
//        FileOutputStream fos = null;
//        try{
//            fis = new FileInputStream(src);// 31
//            fos = new FileOutputStream(target); // 28
//            //计算长度
//            byte[] buf = new byte[80];
//            int size = fis.read(buf);
//            int PCMSize = 0;
//            while (size != -1) {
//                PCMSize += size;
//                size = fis.read(buf);
//            }
//            //填入参数，比特率等等。这里用的是16位单声道 8000 hz
//            WaveHeader header = new WaveHeader();
//            //长度字段 = 内容的大小（PCMSize) + 头部字段的大小(不包括前面4字节的标识符RIFF以及fileLength本身的4字节)
//            header.fileLength = PCMSize + (44 - 8);
//            header.FmtHdrLeth = 16;
//            header.BitsPerSample = 16;
//            header.Channels = 2;
//            header.FormatTag = 0x0001;
//            header.SamplesPerSec = 8000;
//            header.BlockAlign = (short)(header.Channels * header.BitsPerSample / 8);
//            header.AvgBytesPerSec = header.BlockAlign * header.SamplesPerSec;
//            header.DataHdrLeth = PCMSize;
//
//            byte[] h = header.getHeader();
//
//            assert h.length == 44; //WAV标准，头部应该是44字节
//            //write header
//            fos.write(h, 0, h.length);
//            //write data stream
//            fis = new FileInputStream(src); // 60
//            size = fis.read(buf);
//
//            while (size != -1) {
////
////            //转码后输出
////            short[] bytes3 = d.process(buf);
//
////            fos.write(toByteArray(bytes3), 0, size);
//                size = fis.read(buf);
//            }
//        }catch (Exception e){
//            e.getMessage();
//        }finally {
//            if(fos != null){
//                fos.close();
//            }
//            try{
//                if (fis != null){
//                fis.close();// 77
//            }}catch (Exception e){
//                e.getMessage();
//            }
//
//        }
//    }

    public static byte[] toByteArray(short[] src) {

        int count = src.length;
        byte[] dest = new byte[count << 1];
        for (int i = 0; i < count; i++) {
            dest[i * 2] = (byte) (src[i] >> 8);
            dest[i * 2 + 1] = (byte) (src[i] >> 0);
        }
        return dest;
    }

}


