package com.taikang.dic.ltci.portal.common.util;

import org.apache.commons.lang3.StringUtils;

import com.taikang.dic.ltci.portal.common.enumeration.FileTypeEnum;

public class FileTypeDecideUtil {

  /** 图片格式 */
  public static final String FILE_OF_PICTURE_LAYOUT =
      "bmp, jpeg, jpg, png, tiff, gif, pcx, tga, exif, fpx, svg, psd, cdr, pcd, dxf, ufo, eps, ai, raw, wmf";

  /** 音频格式 */
  public static final String FILE_OF_VOICE_FREQUENCY_LAYOUT =
      "cd, wave, aiff, au, mpeg, mp3, mpeg-4, midi, wma, realaudio, vqf, oggvorbis, amr, 3ga, m4a";

  /** 视频格式 */
  public static final String FILE_OF_VIDEO_FREQUENCY_LAYOUT =
      "mpeg, mpg, dat, mp4, 3gp, avi, mov, asf, wmv, navi, ra, ram, mkv, flv, f4v, rmvb, webm, hddvd, qsv";

  public static String getFileType(String suffix) {
    String str = suffix.toLowerCase();
    String fileType = "";
    if (StringUtils.isBlank(suffix)) {
      return fileType;
    }
    if (FILE_OF_PICTURE_LAYOUT.contains(str)) {
      fileType = FileTypeEnum.PICTURE.getValue();
    }
    if (FILE_OF_VOICE_FREQUENCY_LAYOUT.contains(str)) {
      fileType = FileTypeEnum.AUDIO.getValue();
    }
    if (FILE_OF_VIDEO_FREQUENCY_LAYOUT.contains(str)) {
      fileType = FileTypeEnum.VIDEO.getValue();
    }
    return fileType;
  }
}
